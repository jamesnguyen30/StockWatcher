package com.example.stockwatcher.ui.fragments.runningStock

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.custom.runningStock.RunningStockLayoutManager
import com.example.stockwatcher.databinding.FragmentRunningStockBinding
import com.example.stockwatcher.ui.activities.MainActivity
import com.example.stockwatcher.ui.fragments.watching.WatchingFragment

class RunningStockFragment : Fragment(){

    lateinit var binding:FragmentRunningStockBinding;
    var adapter: RunningStockAdapter = RunningStockAdapter()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        binding = FragmentRunningStockBinding.inflate(inflater, container, false )

        recyclerView = binding.runningStockRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = RunningStockLayoutManager(binding.root.context)

        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            var timeDragging:Long = 0;
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                when(newState){
                    RecyclerView.SCROLL_STATE_IDLE -> recyclerView.smoothScrollToPosition(adapter.itemCount)
                    RecyclerView.SCROLL_STATE_DRAGGING -> {
                        timeDragging = System.currentTimeMillis()

                    }
                    RecyclerView.SCROLL_STATE_SETTLING -> {
                        if(System.currentTimeMillis() - timeDragging < 100){
                            (activity as? MainActivity)?.startWatchingFragment()
                        } else {
                            recyclerView.smoothScrollToPosition(adapter.itemCount)
                        }
                    }
                }
            }
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        recyclerView.smoothScrollToPosition(adapter.itemCount)

    }

//    private fun startWatchingFragment(){
//        //Bring up BottomSheetView
//        var watchingFragment = WatchingFragment()
//        activity?.supportFragmentManager?.let{
//            watchingFragment.show(it, "WatchingFragment")
//        }
//    }
}