package com.example.stockwatcher.ui.fragments.searchStock

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.IEXSearchApiResponse
import com.example.stockwatcher.data.models.Stock
import com.example.stockwatcher.databinding.TickerItemViewHolderBinding
import com.example.stockwatcher.ui.fragments.watching.WatchingItemViewHolder

class SearchStockAdapter(val context: Context?): RecyclerView.Adapter<WatchingItemViewHolder>(){

    var dataStore: List<IEXSearchApiResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchingItemViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var itemBinding = TickerItemViewHolderBinding.inflate(inflater, parent, false)
        return WatchingItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return dataStore.count()
    }

    override fun onBindViewHolder(holder: WatchingItemViewHolder, position: Int) {
        var ticker = dataStore.get(position)

        var stock = Stock(ticker.symbol, ticker.securityName, 300f, 0.02f)
        holder.bind(stock)
    }

    fun updateDataStore(newData: List<IEXSearchApiResponse>){
        dataStore = newData
        notifyDataSetChanged()
    }
}
