package com.example.stockwatcher.ui.fragments.watching

import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.data.models.Stock
import com.example.stockwatcher.databinding.TickerItemViewHolderBinding

class WatchingItemViewHolder( var binding: TickerItemViewHolderBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(stock: Stock){
       binding.stock = stock
    }
}