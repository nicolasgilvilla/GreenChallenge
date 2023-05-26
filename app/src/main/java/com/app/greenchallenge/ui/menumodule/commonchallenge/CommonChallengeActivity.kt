package com.app.greenchallenge.ui.menumodule.commonchallenge

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.greenchallenge.R
import com.app.greenchallenge.data.database.ChallengeLocalDataSourceImpl
import com.app.greenchallenge.data.database.FirestoreManager
import com.app.greenchallenge.databinding.ActivityCommonChallengeBinding
import com.data.datasource.FirestoreCallback
import com.data.repository.ChallengeRepository
import com.domain.ModelCommon
import com.google.firebase.firestore.DocumentSnapshot
import com.usecases.GetChallengesUseCase

class CommonChallengeActivity : AppCompatActivity(), CommonOnClickListener {

    private lateinit var mBinding: ActivityCommonChallengeBinding
    private var commonList = emptyList<ModelCommon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCommonChallengeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.layoutToolbar.titleBar.text = getString(R.string.common_challenge)
        mBinding.layoutToolbar.goBackButton.setOnClickListener {
            onBackPressed()
        }

        setUpFirebase()

        commonList =
            GetChallengesUseCase(ChallengeRepository(ChallengeLocalDataSourceImpl())).invoke()


    }

    private fun setUpFirebase() {
        val tempList = mutableListOf<ModelCommon>()
        val firestoreManager = FirestoreManager()
        for (i in 0 until 4) {
            var id = i.toString()
            if (i == 0) id = "testeo"
            firestoreManager.getDocuments(object : FirestoreCallback {
                override fun onSuccess(documents: DocumentSnapshot) {

                    val title = documents.data?.getValue("title").toString()
                    val action = documents.data?.getValue("action").toString()
                    val effects = documents.data?.getValue("effects").toString()
                    val benefits = documents.data?.getValue("benefits").toString()

                    tempList.add(ModelCommon(title, action, effects, benefits))
                    commonList = tempList
                    setupAdapter(commonList)
                }

                override fun onFailure(exception: Exception) {
                    commonList = listOf(ModelCommon("", "", "", ""))
                }
            }, id)

        }

    }

    private fun setupAdapter(commonList: List<ModelCommon>) {
        val adapter = CommonAdapter(listCommon = commonList, listener = this)
        mBinding.rChallengeCommon.adapter = adapter
        val linear =
            LinearLayoutManager(this@CommonChallengeActivity, LinearLayoutManager.VERTICAL, false)
        mBinding.rChallengeCommon.layoutManager = linear
    }

    override fun onClick(view: View, position: Int, commonList: List<ModelCommon>) {
        val intent = Intent(this@CommonChallengeActivity, DetailActivity::class.java)
        intent.putExtra(
            "titleCommon", commonList[position].title
        )
        intent.putExtra(
            "effect", commonList[position].effects
        )
        intent.putExtra(
            "benefit", commonList[position].benefits
        )
        intent.putExtra(
            "action", commonList[position].action
        )
        startActivity(intent)
    }
}