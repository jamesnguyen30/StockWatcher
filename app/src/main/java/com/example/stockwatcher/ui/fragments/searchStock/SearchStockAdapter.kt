package com.example.stockwatcher.ui.fragments.searchStock

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.TickerApiResponse
import com.example.stockwatcher.databinding.TickerSuggestionViewHolderBinding

class SearchStockAdapter(val context: Context?): RecyclerView.Adapter<SearchStockViewHolder>(){

    var dataStore: List<TickerApiResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchStockViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var itemBinding = TickerSuggestionViewHolderBinding.inflate(inflater, parent, false)
        return SearchStockViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return dataStore.count()
    }

    override fun onBindViewHolder(holder: SearchStockViewHolder, position: Int) {
        var ticker = dataStore.get(position)
        holder.bind(ticker)
    }

    fun updateDataStore(newData: List<TickerApiResponse>){
        dataStore = newData
        notifyDataSetChanged()
    }
}
