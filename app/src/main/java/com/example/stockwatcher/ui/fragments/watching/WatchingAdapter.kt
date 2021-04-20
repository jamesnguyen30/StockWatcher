package com.example.stockwatcher.ui.fragments.watching

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.data.models.RetroPhoto
import com.example.stockwatcher.data.models.Stock
import com.example.stockwatcher.databinding.WatchingItemViewHolderBinding

class WatchingAdapter: RecyclerView.Adapter<WatchingItemViewHolder> {

    var mockArray:ArrayList<Stock> = ArrayList()
    var context: Context?


    constructor(){
        context = null
    }


    constructor(context: Context, dataList: List<RetroPhoto>){
        this.context = context
    }

    init{
        mockArray = ArrayList()
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
        mockArray.add(Stock("APPL", "Apple.Inc", 342.04f, 0.2f))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchingItemViewHolder {
        var inflater:LayoutInflater = LayoutInflater.from(parent.context)
        var itemBinding: WatchingItemViewHolderBinding = WatchingItemViewHolderBinding.inflate(inflater, parent, false)
        return WatchingItemViewHolder(
            itemBinding
        )
    }

    override fun getItemCount(): Int {
        return mockArray.size;
    }

    override fun onBindViewHolder(holder: WatchingItemViewHolder, position: Int) {
        var stock = mockArray.get(position)
        holder.bind(stock)
    }


}