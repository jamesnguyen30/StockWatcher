package com.example.stockwatcher.ui.fragments.news

import android.app.ActionBar
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.example.stockwatcher.api.models.News
import com.example.stockwatcher.custom.RoundCornerTransformation
import com.example.stockwatcher.databinding.NewsItemViewholderBinding

open class NewsViewHolder(binding: NewsItemViewholderBinding):RecyclerView.ViewHolder(binding.root){

    var binding: NewsItemViewholderBinding = binding
    fun bind(news: News){
        binding.news = news
    }

    companion object{
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(imageView: ImageView, imageUrl: String?){
            if(imageUrl!=""){
                Glide.with(imageView.context)
                    .load(imageUrl)
                    .transform(MultiTransformation(CenterCrop(), RoundCornerTransformation(25f)))
                    .into(imageView)
            }
        }
    }
}