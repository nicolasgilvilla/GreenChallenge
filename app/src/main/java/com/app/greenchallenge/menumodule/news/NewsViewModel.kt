package com.app.greenchallenge.menumodule.news

import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel() {
    private var newsUrlsLiveData = arrayListOf<NewsModel>()

    init {
        fetchNewsUrls()
    }

    fun getNewsUrls(): ArrayList<NewsModel> {
        return newsUrlsLiveData
    }

    private fun fetchNewsUrls() {
        val newsUrls = DataNews.newsUrls
        newsUrlsLiveData = newsUrls
    }
}
