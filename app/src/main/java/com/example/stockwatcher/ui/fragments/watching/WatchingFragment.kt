package com.example.stockwatcher.ui.fragments.watching

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.R
import com.example.stockwatcher.ui.adapters.StockRVAdapter

class WatchingFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_watching, container, false)
        var recyclerView: RecyclerView = view.findViewById(R.id.stock_recycler_view)
        recyclerView.adapter = StockRVAdapter()
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        return view;
    }

}