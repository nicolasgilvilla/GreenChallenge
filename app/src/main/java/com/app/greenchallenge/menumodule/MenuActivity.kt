package com.app.greenchallenge.menumodule

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.greenchallenge.databinding.ActivityMenuBinding
import com.app.greenchallenge.menumodule.achievements.AchievementsActivity

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
        }
    }
}
