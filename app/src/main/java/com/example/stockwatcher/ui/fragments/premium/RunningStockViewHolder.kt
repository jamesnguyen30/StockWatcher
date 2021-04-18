package com.example.stockwatcher.ui.fragments.premium

import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.MinimizedStock
import com.example.stockwatcher.databinding.RunningStockViewHolderBinding

class RunningStockViewHolder(binding: RunningStockViewHolderBinding): RecyclerView.ViewHolder(binding.root){

   var binding:RunningStockViewHolderBinding = binding

   fun bind(stock: MinimizedStock){
     binding.stock = stock;
   }
}