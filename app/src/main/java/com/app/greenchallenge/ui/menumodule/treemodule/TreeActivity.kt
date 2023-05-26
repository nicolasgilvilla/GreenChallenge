package com.app.greenchallenge.ui.menumodule.treemodule

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.databinding.ActivityTreeBinding

class TreeActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityTreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTreeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.layoutToolbar.titleBar.text = "Dona y siembra"

        mBinding.layoutToolbar.goBackButton.setOnClickListener{
            onBackPressed()
        }

        mBinding.donateButton.setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
        }

    }
}