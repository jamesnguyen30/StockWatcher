package com.example.stockwatcher.ui.helpers

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.ui.fragments.watching.WatchingAdapter

class WatchingListItemTouchHelper(var context: Context, private var mAdapterActions: AdapterActions) :
        ItemTouchHelper.Callback(){

    interface AdapterActions{
        fun swap(from: Int, to: Int)
        fun removeAt(position: Int)
    }

    override fun isLongPressDragEnabled(): Boolean {
       return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
//        var swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        var swipeFlags = ItemTouchHelper.LEFT
        var dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        mAdapterActions.swap(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        when(direction){
//            ItemTouchHelper.RIGHT -> {
//                Log.d("ItemTouchHelperCallback", "onSwiped RIGHT")
//            }
            ItemTouchHelper.LEFT -> {
                Log.d("ItemTouchHelperCallback", "onSwiped LEFT")
                mAdapterActions.removeAt(viewHolder.adapterPosition)
            }
        }
    }
}