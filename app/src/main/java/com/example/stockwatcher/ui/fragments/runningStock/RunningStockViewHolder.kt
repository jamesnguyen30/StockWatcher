package com.example.stockwatcher.ui.fragments.runningStock

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.api.models.MinimizedStock
import com.example.stockwatcher.databinding.RunningStockViewHolderBinding

class RunningStockViewHolder(private var binding: RunningStockViewHolderBinding, private var onClickHandler: ()->Unit): RecyclerView.ViewHolder(binding.root) {


    init{
        itemView.setOnClickListener{
            onClickHandler()
        }
    }

    fun bind(stock: MinimizedStock) {
        binding.stock = stock;

    }

    companion object {
        @BindingAdapter("intToStringText")
        @JvmStatic
        fun loadIntToString(textView: TextView, intValue: Int) {
            textView.text = intValue.toString()
        }
    }
}
