package com.example.stockwatcher.ui.fragments.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.R
import com.example.stockwatcher.databinding.FragmentNewsBinding
import com.example.stockwatcher.ui.adapters.NewsAdapter

class NewsFragment : Fragment(R.layout.fragment_news) {

    lateinit var binding: FragmentNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false )

        var recyclerView: RecyclerView = binding.newsRecyclerView
        recyclerView.adapter = NewsAdapter()
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)

        return binding.root
    }
}
