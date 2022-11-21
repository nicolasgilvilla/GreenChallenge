package com.app.greenchallenge

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.databinding.ActivitySplashBinding
import com.app.greenchallenge.loginmodule.LoginActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        moveAnimationsToNextScreen(mBinding.tvFooter, mBinding.ivSiop)
    }

    private fun moveAnimationsToNextScreen(
        tvTittle: TextView,
        ivIcon: ImageView
    ) {
        tvTittle.animate()
            .setStartDelay(2000)
            .translationX(-1500F).duration = 1000

        ivIcon.animate()
            .setStartDelay(2000)
            .translationX(-1500F).duration = 1000

        GlobalScope.launch {
            delay(2800)
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }
    }
}
