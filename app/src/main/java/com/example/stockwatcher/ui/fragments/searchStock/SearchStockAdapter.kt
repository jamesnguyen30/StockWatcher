package com.example.stockwatcher.ui.fragments.searchStock

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.SearchSymbol
import com.example.stockwatcher.databinding.TickerItemViewHolderBinding
import com.example.stockwatcher.ui.fragments.watching.TickerItemViewHolder

class SearchStockAdapter(val context: Context?): RecyclerView.Adapter<TickerItemViewHolder>(){

    var dataStore: List<SearchSymbol> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TickerItemViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var itemBinding = TickerItemViewHolderBinding.inflate(inflater, parent, false)
        return TickerItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return dataStore.count()
    }

    override fun onBindViewHolder(holder: TickerItemViewHolder, position: Int) {
        var symbol = dataStore[position]

        holder.bind(symbol)
    }

    fun updateDataStore(newData: List<SearchSymbol>){
        dataStore = newData
        notifyDataSetChanged()
    }
}
