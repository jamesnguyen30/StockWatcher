package com.example.stockwatcher.custom.runningStock

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

class RunningStockRecyclerView: RecyclerView{

    constructor(context: Context):super(context){
    }

    override fun onScrollStateChanged(state: Int) {
        when(state){
            SCROLL_STATE_IDLE -> this.scrollToPosition(adapter!!.itemCount-1)
            SCROLL_STATE_SETTLING -> this.scrollToPosition(adapter!!.itemCount-1)
        }

    }
}