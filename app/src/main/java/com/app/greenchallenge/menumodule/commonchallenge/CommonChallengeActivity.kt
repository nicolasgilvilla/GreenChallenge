package com.app.greenchallenge.menumodule.commonchallenge

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.greenchallenge.R
import com.app.greenchallenge.databinding.ActivityCommonChallengeBinding

class CommonChallengeActivity : AppCompatActivity(), CommonOnClickListener {

    private lateinit var mBinding: ActivityCommonChallengeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCommonChallengeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.layoutToolbar.titleBar.text = getString(R.string.common_challenge)
        mBinding.layoutToolbar.goBackButton.setOnClickListener {
            onBackPressed()
        }
        val commonList: List<ModelCommon> = listOf(
            ModelCommon(
                title = getString(R.string.common_challenge_text_title_example),
                action = getString(R.string.common_challenge_text_action_example),
                effects = getString(R.string.common_challenge_text_effect_example),
                benefits = getString(R.string.common_challenge_text_benefits_example)
            ),
            ModelCommon(
                title = getString(R.string.model1),
                action = getString(R.string.model2),
                effects = getString(R.string.model3),
                benefits = getString(R.string.model4)
            ),
            ModelCommon(
                title = getString(R.string.model5),
                action = getString(R.string.model6),
                effects = getString(R.string.model7),
                benefits = getString(R.string.model8)
            ),
            ModelCommon(
                title = getString(R.string.model9),
                action = getString(R.string.mode10),
                effects = getString(R.string.model12),
                benefits = getString(R.string.model11)
            ),
        )

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