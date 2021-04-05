package com.example.stockwatcher.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.News
import com.example.stockwatcher.api.models.NewsSource
import com.example.stockwatcher.data.datastore.NewsMockDatastore
import com.example.stockwatcher.databinding.NewsItemViewholderBinding
import com.example.stockwatcher.ui.viewholders.NewsViewHolder

class NewsAdapter: RecyclerView.Adapter<NewsViewHolder>{
    private var datastore:NewsMockDatastore = NewsMockDatastore()

    constructor(){
        datastore.addNews(News(
            NewsSource("",""),
            "",
            "Something very big is happening",
            "Here in sillicon valley",
            "",
            "","",""))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var inflater: LayoutInflater = LayoutInflater.from(parent.context)
        var itemBinding: NewsItemViewholderBinding = NewsItemViewholderBinding.inflate(inflater)
        return NewsViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return datastore.totalNews()
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int){
        var news = datastore.getNews(position)
        Log.d("News ", news.toString())
        holder.bind(news)
    }

   fun updateNewsDatastore(newsData: ArrayList<News>){
       Log.d("Adapter", "here")
       datastore.updateNewsData(newsData)
   }
}