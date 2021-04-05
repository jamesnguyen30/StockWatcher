package com.example.stockwatcher.ui.viewholders

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.News
import com.example.stockwatcher.databinding.NewsItemViewholderBinding

open class NewsViewHolder(binding: NewsItemViewholderBinding):RecyclerView.ViewHolder(binding.root){

    var binding: NewsItemViewholderBinding = binding
    fun bind(news: News){
        Log.d("viewholder", news.toString())
        binding.news = news
    }
}