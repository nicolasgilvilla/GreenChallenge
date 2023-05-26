package com.app.greenchallenge.menumodule

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.databinding.ActivityMenuBinding
import com.app.greenchallenge.menumodule.achievements.AchievementsActivity
import com.app.greenchallenge.menumodule.commonchallenge.CommonChallengeActivity
import com.app.greenchallenge.menumodule.adapter.CustomAdapter
import com.app.greenchallenge.desordenado.menumodule.commonchallenge.CommonChallengeActivity
import com.app.greenchallenge.menumodule.dailychallenge.DailyChallengeActivity
import com.app.greenchallenge.menumodule.news.NewsListActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            btnAchievements.setOnClickListener {
                startActivity(Intent(this@MenuActivity, AchievementsActivity::class.java))
            }
            btnDailyChallenge.setOnClickListener {
                startActivity(Intent(this@MenuActivity, DailyChallengeActivity::class.java))
            }
            btnCommonChallenge.setOnClickListener {
                startActivity(Intent(this@MenuActivity, CommonChallengeActivity::class.java))
            }
            btnNews.setOnClickListener {
                startActivity(Intent(this@MenuActivity, NewsListActivity::class.java))
            }
        }
    }
}
