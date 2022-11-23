package com.app.greenchallenge

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.app.greenchallenge.databinding.ActivitySplashBinding
import com.app.greenchallenge.viewpagermodule.ViewPagerActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        moveAnimationsToNextScreen(mBinding.tvFooter, mBinding.tvTittle, mBinding.lottie)
    }

    private fun moveAnimationsToNextScreen(
        tvFooter: TextView,
        tvTittle: TextView,
        lottie: LottieAnimationView
    ) {
        tvFooter.animate()
            .setStartDelay(3500)
            .translationX(-1500F).duration = 1000

        lottie.animate()
            .setStartDelay(3800)
            .translationX(-1500F).duration = 1000

        tvTittle.animate()
            .setStartDelay(4000)
            .translationX(-1500F).duration = 1000

        GlobalScope.launch {
            delay(4900)
            startActivity(Intent(this@SplashActivity, ViewPagerActivity::class.java))
            finish()
        }
    }
}
