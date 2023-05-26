package com.app.greenchallenge.menumodule.news

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.greenchallenge.R
import com.app.greenchallenge.databinding.ActivityNewsListBinding

class NewsListActivity : AppCompatActivity(), OpenWebSite {
    private lateinit var binding: ActivityNewsListBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var mAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layoutToolbar.titleBar.text = getString(R.string.news)

        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        mAdapter = NewsAdapter(this, viewModel.getNewsUrls())
        binding.recyclerViewNews.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        binding.layoutToolbar.goBackButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun openNewsUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    override fun onClick(item: String) {
        openNewsUrl(item)
    }


}
