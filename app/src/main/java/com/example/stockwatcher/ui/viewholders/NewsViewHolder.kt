package com.example.stockwatcher.ui.viewholders

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.News
import com.example.stockwatcher.databinding.NewsItemViewholderBinding
import com.squareup.picasso.Picasso

open class NewsViewHolder(binding: NewsItemViewholderBinding):RecyclerView.ViewHolder(binding.root){

    var binding: NewsItemViewholderBinding = binding
    fun bind(news: News){
        Log.d("viewholder", news.toString())
        binding.news = news
    }

    companion object{
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(imageView: ImageView, imageUrl: String){
            imageView.layoutParams.width = 930;
            if(imageUrl!=""){
                Picasso.get()
                    .load(imageUrl)
                    .centerCrop()
                    .fit()
                    .into(imageView)
            }
        }
    }
}