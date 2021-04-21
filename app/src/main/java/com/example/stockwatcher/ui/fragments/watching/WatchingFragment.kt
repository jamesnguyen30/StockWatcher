package com.example.stockwatcher.ui.fragments.watching

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.R
import com.example.stockwatcher.databinding.FragmentWatchingBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WatchingFragment : BottomSheetDialogFragment(), View.OnClickListener {

    lateinit var binding: FragmentWatchingBinding;
    var recyclerView: RecyclerView? = null;


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
        recyclerView!!.adapter = WatchingAdapter()
        recyclerView!!.layoutManager = LinearLayoutManager(binding.root.context)

//        binding.addStockButton.setOnClickListener(this)

        return binding.root;
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
//            R.id.add_stock_button -> {
//               //TODO: Add stock button
//
//            }
        }
    }
}