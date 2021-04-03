package com.example.stockwatcher.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.data.models.RetroPhoto
import com.example.stockwatcher.data.models.Stock
import com.example.stockwatcher.databinding.StockItemViewholderBinding

class StockRVAdapter: RecyclerView.Adapter<StockRVAdapter.StockListViewHolder> {

    var mockArray:ArrayList<Stock>
    var dataList: List<RetroPhoto>?;
    var context: Context?

    constructor(){
        context = null
        dataList = null
    }


    constructor(context: Context, dataList: List<RetroPhoto>){
        this.dataList = dataList
        this.context = context
    }

    init{
        mockArray = ArrayList()
        mockArray.add(
            Stock(
                "url1",
                "Title 1",
                "Description 1"
            )
        )
        mockArray.add(
            Stock(
                "url2",
                "Title 2",
                "Description 1"
            )
        )
        mockArray.add(
            Stock(
                "url3",
                "Title 3",
                "Description 1"
            )
        )
        mockArray.add(
            Stock(
                "url4",
                "Title 4",
                "Description 1"
            )
        )
    }

    class StockListViewHolder(binding: StockItemViewholderBinding): RecyclerView.ViewHolder(binding.root) {

        var binding: StockItemViewholderBinding = binding

        fun bind(stock: Stock){
            binding.stock = stock
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockListViewHolder {
        var inflater:LayoutInflater = LayoutInflater.from(parent.context)
        var itemBinding: StockItemViewholderBinding = StockItemViewholderBinding.inflate(inflater, parent, false)
        return StockListViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return 3;
    }

    override fun onBindViewHolder(holder: StockListViewHolder, position: Int) {
        var stock = mockArray.get(position)
        holder.bind(stock)
    }


}