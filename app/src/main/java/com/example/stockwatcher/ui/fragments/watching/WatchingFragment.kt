package com.example.stockwatcher.ui.fragments.watching

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.R
import com.example.stockwatcher.databinding.FragmentWatchingBinding
import com.example.stockwatcher.ui.activities.main.MainActivity
import com.example.stockwatcher.ui.helpers.WatchingListItemTouchHelper
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WatchingFragment : BottomSheetDialogFragment(), WatchingNavigator, View.OnClickListener {

    lateinit var binding: FragmentWatchingBinding;
    var recyclerView: RecyclerView? = null;
    private var recyclerViewAdapter = WatchingAdapter()

    var viewModel: WatchingViewModel = WatchingViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.NewsFragmentBottomSheetTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWatchingBinding.inflate(inflater, container, false)
        recyclerView = binding.watchingRecyclerView
        recyclerView!!.adapter = recyclerViewAdapter
        recyclerView!!.layoutManager = LinearLayoutManager(binding.root.context)

        var watchList = (activity as? MainActivity)?.getWatchList() ?: ArrayList()

        val itemTouchHelper = ItemTouchHelper(WatchingListItemTouchHelper(binding.root.context,
        object: WatchingListItemTouchHelper.AdapterActions{
            override fun swap(from: Int, to: Int) {
               recyclerViewAdapter.swap(from, to)
            }

            override fun removeAt(position: Int) {
                recyclerViewAdapter.removeAt(position)
            }
        }))
        itemTouchHelper.attachToRecyclerView(recyclerView)

        viewModel.requestData(watchList)

        binding.addButton.setOnClickListener(this)

        return binding.root;
    }

    override fun showLoadingIndicator() {
//        TODO("Not yet implemented")
    }

    override fun hideLoadingIndicator() {
//        TODO("Not yet implemented")
    }

    override fun requestError() {
//        TODO("Not yet implemented")
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.addButton -> {
               //TODO: Add stock button

            }
        }
    }
}