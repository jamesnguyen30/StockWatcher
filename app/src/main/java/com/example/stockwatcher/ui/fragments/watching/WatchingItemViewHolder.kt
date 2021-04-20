package com.example.stockwatcher.ui.fragments.watching

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.data.models.Stock
import com.example.stockwatcher.databinding.WatchingItemViewHolderBinding

class WatchingItemViewHolder( var binding: WatchingItemViewHolderBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(stock: Stock){
       binding.stock = stock
    }

}