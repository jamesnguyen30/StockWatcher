package com.example.stockwatcher.ui.fragments.runningStock

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.MinimizedStock
import com.example.stockwatcher.api.models.StockQuote
import com.example.stockwatcher.databinding.RunningStockViewHolderBinding

class RunningStockAdapter(): RecyclerView.Adapter<RunningStockViewHolder>(){

    lateinit var itemBinding: RunningStockViewHolderBinding;
    private var dataStore: ArrayList<StockQuote>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunningStockViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        itemBinding = RunningStockViewHolderBinding.inflate(inflater, parent, false)

        return RunningStockViewHolder(itemBinding);
    }

    override fun getItemCount(): Int {
        dataStore?.let{
            return it.count()
        }
        return 0
    }

    override fun onBindViewHolder(holder: RunningStockViewHolder, position: Int) {
        dataStore?.let{
            holder.bind(it.get(position))
        }
    }
}