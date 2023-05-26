package com.app.greenchallenge.menumodule.dailychallenge

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.R
import com.app.greenchallenge.common.dialog.GenerateDialogGeneric
import com.app.greenchallenge.databinding.ActivityDailyChallengeBinding

class DailyChallengeActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDailyChallengeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDailyChallengeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.layoutToolbar.titleBar.text = getString(R.string.daily_challenge)

        with(mBinding) {
            layoutToolbar.goBackButton.setOnClickListener {
                onBackPressed()
            }
            btnQuestion.setOnClickListener {
                val number = textNumber.text.toString()
                val total = number.toInt() + 1
                textNumber.text = total.toString()
                btnLeft.visibility = VISIBLE
                btnQuestion.visibility = INVISIBLE
            }
            btnLeft.setOnClickListener {
                val number = textNumber.text.toString()
                val total = number.toInt() - 1
                textNumber.text = total.toString()
                btnLeft.visibility = INVISIBLE
                btnQuestion.visibility = VISIBLE
            }
            textViewMore.setOnClickListener {
                GenerateDialogGeneric.showDialogGeneric(
                    this@DailyChallengeActivity,
                    this@DailyChallengeActivity.getString(R.string.text_info_why),
                    R.string.view_more.toString(),
                    null
                )
            }
            btnBenefits.setOnClickListener {
                GenerateDialogGeneric.showDialogGeneric(
                    this@DailyChallengeActivity,
                    this@DailyChallengeActivity.getString(R.string.text_benefits),
                    R.string.text_btn_benefits.toString(),
                    null
                )
            }
        }
    }


}