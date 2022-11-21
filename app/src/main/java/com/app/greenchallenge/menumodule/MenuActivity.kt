package com.app.greenchallenge.menumodule

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.greenchallenge.R
import com.app.greenchallenge.databinding.ActivityMenuBinding
import com.app.greenchallenge.menumodule.achievements.AchievementsActivity
import com.app.greenchallenge.menumodule.adapter.CustomAdapter

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            var imageList: Array<Int> = arrayOf(
                R.drawable.ic_cambio_climatico,
                R.drawable.ic_splash
            )

            var arrayAdapter = CustomAdapter(imageList)

            recycler.adapter = arrayAdapter
            val linear =
                LinearLayoutManager(this@MenuActivity, LinearLayoutManager.HORIZONTAL, false)
            recycler.layoutManager = linear
            recycler.setHasFixedSize(true)

            btnAchievements.setOnClickListener {
                startActivity(Intent(this@MenuActivity, AchievementsActivity::class.java))
            }
        }
    }
}
