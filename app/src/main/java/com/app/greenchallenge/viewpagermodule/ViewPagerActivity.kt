package com.app.greenchallenge.viewpagermodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.greenchallenge.R
import com.app.greenchallenge.databinding.ActivityViewPagerBinding
import com.app.greenchallenge.loginmodule.LoginActivity
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity(), ViewPagerOnClickListener {

    private lateinit var mBinding: ActivityViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val onBoardingList: List<Board> = listOf(
            Board(
                image = R.drawable.first_photo,
                title = getString(R.string.on_boarding_title_welcome),
                description = getString(R.string.on_boarding_description_welcome)
            ),
            Board(
                image = R.drawable.second_photo,
                title = getString(R.string.on_boarding_title_pokedex),
                description = getString(R.string.on_boarding_description_pokedex)
            ),
            Board(
                image = R.drawable.third_photo,
                title = getString(R.string.on_boarding_title_the_best),
                description = getString(R.string.on_boarding_description_the_best)
            )
        )

        setupAdapter(onBoardingList)
        setupTabLayout()

    }

    private fun setupAdapter(onBoardingList: List<Board>) {
        val adapter = ViewPagerAdapter(
            boardList = onBoardingList,
            listener = this
        )
        mBinding.viewPager.adapter = adapter
    }

    private fun setupTabLayout() {
        TabLayoutMediator(mBinding.viewPagerTab, mBinding.viewPager) { _, _ ->
        }.attach()
    }

    override fun onClick() {
        finish()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}