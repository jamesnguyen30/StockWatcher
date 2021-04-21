package com.example.stockwatcher.custom.runningStock

import android.content.Context
import android.graphics.PointF
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

class RunningStockLayoutManager : LinearLayoutManager {

    constructor(context: Context): this(context, HORIZONTAL, false){
    }

    constructor(context: Context, orientation: Int, reverseLayout: Boolean): super(context, orientation, reverseLayout){
    }

    override fun smoothScrollToPosition(recyclerView: RecyclerView?, state: RecyclerView.State?, position: Int) {
        var smoothScroller: RecyclerView.SmoothScroller =  CustomScroller(recyclerView!!.context)
        smoothScroller.targetPosition = position;
        startSmoothScroll(smoothScroller)
    }

    class CustomScroller : LinearSmoothScroller{
        constructor(context: Context): super(context)

        override fun getVerticalSnapPreference(): Int {
            return SNAP_TO_START
        }

        override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics?): Float {
            return super.calculateSpeedPerPixel(displayMetrics) * 100f;
        }
    }
}