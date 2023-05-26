package com.app.greenchallenge.desordenado.menumodule.commonchallenge

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.greenchallenge.data.database.ChallengeLocalDataSourceImpl
import com.app.greenchallenge.databinding.ActivityCommonChallengeBinding
import com.app.greenchallenge.menumodule.commonchallenge.CommonAdapter
import com.app.greenchallenge.menumodule.commonchallenge.CommonOnClickListener
import com.app.greenchallenge.menumodule.commonchallenge.DetailActivity
import com.data.repository.ChallengeRepository
import com.domain.ModelCommon
import com.usecases.GetChallengesUseCase

class CommonChallengeActivity : AppCompatActivity(), CommonOnClickListener {

    private lateinit var mBinding: ActivityCommonChallengeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCommonChallengeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val commonList: List<ModelCommon> =
            GetChallengesUseCase(ChallengeRepository(ChallengeLocalDataSourceImpl())).invoke()


        setupAdapter(commonList)

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