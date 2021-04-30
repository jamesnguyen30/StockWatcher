package com.example.stockwatcher.ui.helpers

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.R
import com.example.stockwatcher.ui.fragments.watching.WatchingAdapter

class WatchingListItemTouchHelper(var context: Context, private var mAdapterActions: AdapterActions) :
        ItemTouchHelper.Callback(){

    interface AdapterActions{
        fun swap(from: Int, to: Int)
        fun removeAt(position: Int)
    }

    private val sBackground = ColorDrawable()
    private val sDeleteIcon = ContextCompat.getDrawable(context, R.drawable.ic_round_delete_24)
    private val COLOR_RED = ContextCompat.getColor(context, R.color.red)
    private val COLOR_WHITE = ContextCompat.getColor(context, R.color.white)
    private var itemView: View? = null


    init{
        sDeleteIcon!!.colorFilter = BlendModeColorFilter(COLOR_WHITE, BlendMode.SRC_ATOP)
    }


    override fun isLongPressDragEnabled(): Boolean {
       return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
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
            ItemTouchHelper.LEFT -> {
                Log.d("ItemTouchHelperCallback", "onSwiped LEFT")
                mAdapterActions.removeAt(viewHolder.adapterPosition)
            }
        }
    }

    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        itemView = viewHolder.itemView
        if(dX < 0){
            val iconMargin = (itemView!!.height  - sDeleteIcon!!.intrinsicHeight)/ 2
            sBackground.color = COLOR_RED
            sBackground.setBounds(
                    itemView!!.right + (dX.toInt()),
                    itemView!!.top,
                    itemView!!.right,
                    itemView!!.bottom
            )

            val iconTop = itemView!!.top + iconMargin
            val iconRight = itemView!!.right - iconMargin
            val iconLeft = iconRight - sDeleteIcon.intrinsicWidth
            val iconBottom = iconTop + sDeleteIcon.intrinsicHeight

            sDeleteIcon.setBounds(
                    iconLeft,
                    iconTop,
                    iconRight,
                    iconBottom
            )

            sBackground.draw(c)
            sDeleteIcon.draw(c)
        }
    }
}