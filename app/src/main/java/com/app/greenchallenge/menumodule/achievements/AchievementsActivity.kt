package com.app.greenchallenge.menumodule.achievements

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.databinding.ActivityAchievementsBinding

class AchievementsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAchievementsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAchievementsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

        }
    }
}
