package com.example.stockwatcher.ui.fragments.watching

import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.SearchSymbol
import com.example.stockwatcher.api.models.StockQuote
import com.example.stockwatcher.data.models.Stock
import com.example.stockwatcher.databinding.TickerItemViewHolderBinding

class TickerItemViewHolder(var binding: TickerItemViewHolderBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(searchSymbol: SearchSymbol){
       binding.searchSymbol = searchSymbol
    }
}