package com.app.greenchallenge.ui.menumodule.commonchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.R
import com.app.greenchallenge.databinding.ActivityDetailBinding
import com.app.greenchallenge.ui.common.dialog.GenerateDialogGeneric

class DetailActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mBinding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        mBinding.layoutToolbar.goBackButton.setOnClickListener {
            onBackPressed()
        }

        mBinding.layoutToolbar.titleBar.text = getString(R.string.common_challenge)

        val intent = intent
        val intentExtras = intent.extras

        if (intentExtras != null) {
            with(mBinding) {
                val titleExtra = intentExtras["titleCommon"]
                layoutToolbar.titleBar.text = titleExtra.toString()
                val effectExtra = intentExtras["effect"]
                btnWhy.text = effectExtra.toString()
                val benefitExtra = intentExtras["benefit"]
                textEffects.text = benefitExtra.toString()
                val actionExtra = intentExtras["action"]
                cardChallenge.text = actionExtra.toString()
            }
            logicButtons()
        }
    }

    private fun logicButtons() {
        with(mBinding) {
            btnQuestion.setOnClickListener {
                val number = textNumber.text.toString()
                val total = number.toInt() + 1
                textNumber.text = total.toString()
                btnLeft.visibility = android.view.View.VISIBLE
                btnQuestion.visibility = android.view.View.INVISIBLE
            }
            btnLeft.setOnClickListener {
                val number = textNumber.text.toString()
                val total = number.toInt() - 1
                textNumber.text = total.toString()
                btnLeft.visibility = android.view.View.INVISIBLE
                btnQuestion.visibility = android.view.View.VISIBLE
            }
            textViewMore.setOnClickListener {
                GenerateDialogGeneric.showDialogGeneric(
                    this@DetailActivity,
                    this@DetailActivity.getString(R.string.common_challenge_text_effect_example),
                    R.string.view_more.toString(),
                    null
                )
            }
            btnBenefits.setOnClickListener {
                GenerateDialogGeneric.showDialogGeneric(
                    this@DetailActivity,
                    this@DetailActivity.getString(R.string.common_challenge_text_benefits_example) + "\n" + this@DetailActivity.getString(
                        R.string.common_challenge_text_benefits_example_2
                    ),
                    R.string.text_btn_benefits.toString(),
                    null
                )
            }
        }
    }
}