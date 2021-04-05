package com.example.stockwatcher.ui.fragments.watching

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.R
import com.example.stockwatcher.api.services.MockAPIService
import com.example.stockwatcher.api.RetrofitClientInstance
import com.example.stockwatcher.api.models.News
import com.example.stockwatcher.api.services.NewsApiService
import com.example.stockwatcher.data.models.Post
import com.example.stockwatcher.ui.adapters.NewsAdapter
import com.example.stockwatcher.ui.adapters.StockRVAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class WatchingFragment : Fragment() {

//    lateinit var mockApiService: MockAPIService

    var recyclerView: RecyclerView? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_watching, container, false)
        recyclerView = view.findViewById(R.id.stock_recycler_view)
        recyclerView!!.adapter = StockRVAdapter()
        recyclerView!!.layoutManager = LinearLayoutManager(view.context)
        return view;
    }

}