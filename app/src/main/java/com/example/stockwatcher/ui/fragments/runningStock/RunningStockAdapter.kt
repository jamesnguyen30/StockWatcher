package com.example.stockwatcher.ui.fragments.runningStock

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.MinimizedStock
import com.example.stockwatcher.databinding.RunningStockViewHolderBinding

class RunningStockAdapter(var itemClickListener: View.OnClickListener): RecyclerView.Adapter<RunningStockViewHolder>(){

    lateinit var itemBinding: RunningStockViewHolderBinding;
    private var dataStore: ArrayList<MinimizedStock> = ArrayList();

    init{
        dataStore.add(MinimizedStock("APPL", 233, 334))
        dataStore.add(MinimizedStock("ABCD", 233, 334))
        dataStore.add(MinimizedStock("B211", 233, 334))
        dataStore.add(MinimizedStock("C131", 233, 334))
        dataStore.add(MinimizedStock("D123", 233, 334))
        dataStore.add(MinimizedStock("E123", 233, 334))
        dataStore.add(MinimizedStock("F123", 233, 334))
        dataStore.add(MinimizedStock("G133", 233, 334))
        dataStore.add(MinimizedStock("H113", 233, 334))
        dataStore.add(MinimizedStock("I112", 233, 334))
        dataStore.add(MinimizedStock("J134", 233, 334))
        dataStore.add(MinimizedStock("FFG1", 233, 334))
        dataStore.add(MinimizedStock("KAJF", 233, 334))
        dataStore.add(MinimizedStock("FJFF", 233, 334))
        dataStore.add(MinimizedStock("ADBL", 233, 334))
        dataStore.add(MinimizedStock("LFJD", 233, 334))
        dataStore.add(MinimizedStock("LFJk", 233, 334))
        dataStore.add(MinimizedStock("LKFF", 233, 334))
        dataStore.add(MinimizedStock("PQLL", 233, 334))
        dataStore.add(MinimizedStock("LAFB", 233, 334))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunningStockViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        itemBinding = RunningStockViewHolderBinding.inflate(inflater, parent, false)

        return RunningStockViewHolder(itemBinding, itemClickListener);
    }

    override fun getItemCount(): Int {
        return dataStore.count()
    }

    override fun onBindViewHolder(holder: RunningStockViewHolder, position: Int) {
        holder.bind(dataStore.get(position))
    }
}