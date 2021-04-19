package com.example.stockwatcher.ui.fragments.runningStock

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.R
import com.example.stockwatcher.custom.runningStock.RunningStockLayoutManager
import com.example.stockwatcher.databinding.FragmentRunningStockBinding
import com.example.stockwatcher.ui.fragments.watching.WatchingFragment

class RunningStockFragment : Fragment(), View.OnClickListener{

    lateinit var binding:FragmentRunningStockBinding;
    var adapter: RunningStockAdapter = RunningStockAdapter(View.OnClickListener { startWatchingFragment() })
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
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                when(newState){
                    RecyclerView.SCROLL_STATE_IDLE -> recyclerView.smoothScrollToPosition(adapter.itemCount)
                    RecyclerView.SCROLL_STATE_SETTLING -> recyclerView.smoothScrollToPosition(adapter.itemCount)
                }
            }
        })

        binding.testButton.setOnClickListener(this)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        recyclerView.smoothScrollToPosition(adapter.itemCount)

    }

    override fun onStop() {
        super.onStop()
    }

    private fun startWatchingFragment(){
        //Bring up BottomSheetView
        var watchingFragment = WatchingFragment()
        activity?.supportFragmentManager?.let{
            watchingFragment.show(it, "WatchingFragment")
        }
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.running_stock_recycler_view -> {
            }
            R.id.testButton->{
                startWatchingFragment()
            }
        }
    }
}