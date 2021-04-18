package com.example.stockwatcher.ui.fragments.premium

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.MinimizedStock
import com.example.stockwatcher.databinding.RunningStockViewHolderBinding

class RunningStockAdapter: RecyclerView.Adapter<RunningStockViewHolder>{

    lateinit var itemBinding: RunningStockViewHolderBinding;
    private var dataStore: ArrayList<MinimizedStock> = ArrayList();

    constructor(){
        dataStore.add(MinimizedStock("APPL", 233, 334))
        dataStore.add(MinimizedStock("APPL", 233, 334))
        dataStore.add(MinimizedStock("APPL", 233, 334))
        dataStore.add(MinimizedStock("APPL", 233, 334))
        dataStore.add(MinimizedStock("APPL", 233, 334))
        dataStore.add(MinimizedStock("APPL", 233, 334))
        dataStore.add(MinimizedStock("APPL", 233, 334))
        dataStore.add(MinimizedStock("APPL", 233, 334))
        dataStore.add(MinimizedStock("APPL", 233, 334))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunningStockViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        itemBinding = RunningStockViewHolderBinding.inflate(inflater, parent, false)
        return RunningStockViewHolder(itemBinding);

    }

    override fun getItemCount(): Int {
        return dataStore.count()
    }

    override fun onBindViewHolder(holder: RunningStockViewHolder, position: Int) {
        holder.bind(dataStore.get(position))
    }
}