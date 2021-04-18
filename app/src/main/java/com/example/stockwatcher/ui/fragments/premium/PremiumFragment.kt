package com.example.stockwatcher.ui.fragments.premium

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.stockwatcher.R
import com.example.stockwatcher.custom.RoundCornerTransformation
import com.example.stockwatcher.databinding.FragmentPremiumBinding

class PremiumFragment : Fragment(), View.OnClickListener{

    lateinit var binding:FragmentPremiumBinding;
    var adapter: RunningStockAdapter = RunningStockAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        binding = FragmentPremiumBinding.inflate(inflater, container, false )

        var recyclerView = binding.runningStockRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onClick(p0: View?) {
    }
}