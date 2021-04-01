package com.example.stockwatcher.ui.viewholders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.data.models.News
import com.example.stockwatcher.databinding.NewsItemViewholderBinding

open class NewsViewHolder(binding: NewsItemViewholderBinding):RecyclerView.ViewHolder(binding.root){

    var binding: NewsItemViewholderBinding = binding
    fun bind(news: News){
        binding.news = news
    }
}