package com.example.stockwatcher.ui.fragments.news

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.with
import com.example.stockwatcher.api.models.News
import com.example.stockwatcher.api.models.NewsSource
import com.example.stockwatcher.data.datastore.NewsMockDatastore
import com.example.stockwatcher.databinding.NewsItemViewholderBinding
import com.example.stockwatcher.ui.viewholders.NewsViewHolder
import com.squareup.picasso.Picasso

class NewsAdapter: RecyclerView.Adapter<NewsViewHolder>{
    private var datastore:NewsMockDatastore = NewsMockDatastore()
    lateinit var itemBinding: NewsItemViewholderBinding

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
        itemBinding = NewsItemViewholderBinding.inflate(inflater, parent, false)
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