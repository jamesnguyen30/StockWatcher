package com.example.stockwatcher.ui.fragments.watching

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.SearchSymbol
import com.example.stockwatcher.databinding.TickerItemViewHolderBinding

class WatchingAdapter: RecyclerView.Adapter<TickerItemViewHolder>() {

    private var mockArray:ArrayList<SearchSymbol> = ArrayList()
    private var context: Context? = null

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

    fun removeAt(position: Int){
        mockArray.removeAt(position)
        notifyItemRemoved(position)
    }

    fun swap(from: Int, to: Int){
        with(mockArray[from]){
            mockArray[from] = mockArray[to]
            mockArray[to] = this
        }
        notifyItemMoved(from, to)
    }

}