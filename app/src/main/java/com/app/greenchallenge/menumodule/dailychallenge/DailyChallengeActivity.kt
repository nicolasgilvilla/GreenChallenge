package com.app.greenchallenge.menumodule.dailychallenge

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.databinding.ActivityDailyChallengeBinding

class DailyChallengeActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDailyChallengeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDailyChallengeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        with(mBinding) {
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
        }
    }
}