package com.example.stockwatcher.ui.fragments.watching

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.SearchSymbol
import com.example.stockwatcher.data.models.RetroPhoto
import com.example.stockwatcher.data.models.Stock
import com.example.stockwatcher.databinding.TickerItemViewHolderBinding

class WatchingAdapter: RecyclerView.Adapter<TickerItemViewHolder> {

    var mockArray:ArrayList<SearchSymbol> = ArrayList()
    var context: Context?


    constructor(){
        context = null
    }

    init{
        mockArray = ArrayList()
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
        mockArray.add(SearchSymbol("AAPL", "Apple.Inc", "NYSE",
                "UTC06","Common Stock", "United States",
                "USD"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TickerItemViewHolder {
        var inflater:LayoutInflater = LayoutInflater.from(parent.context)
        var itemBinding = TickerItemViewHolderBinding.inflate(inflater, parent, false)
        return TickerItemViewHolder(
            itemBinding
        )
    }

    override fun getItemCount(): Int {
        return mockArray.size;
    }

    override fun onBindViewHolder(holder: TickerItemViewHolder, position: Int) {
        var stock = mockArray.get(position)
        holder.bind(stock)
    }

}