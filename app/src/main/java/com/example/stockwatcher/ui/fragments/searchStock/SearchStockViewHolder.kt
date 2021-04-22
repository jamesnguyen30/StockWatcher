package com.example.stockwatcher.ui.fragments.searchStock

import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.TickerApiResponse
import com.example.stockwatcher.databinding.TickerSuggestionViewHolderBinding

class SearchStockViewHolder(var binding: TickerSuggestionViewHolderBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(ticker: TickerApiResponse){
       binding.ticker = ticker
    }

}
