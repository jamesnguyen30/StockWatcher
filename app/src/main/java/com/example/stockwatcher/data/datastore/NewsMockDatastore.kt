package com.example.stockwatcher.data.datastore

import com.example.stockwatcher.api.models.News

class NewsMockDatastore(){

    var newsData: ArrayList<News> = ArrayList()

    fun updateNewsData(newsData: ArrayList<News>){
        this.newsData = newsData
    }

    fun totalNews(): Int{
        return newsData.size
    }

    fun getNews(position: Int): News {
        return newsData.get(position)
    }

    fun addNews(news: News){
        newsData.add(news)
    }
}