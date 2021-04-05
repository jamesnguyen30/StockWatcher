package com.example.stockwatcher.ui.fragments.news

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockwatcher.R
import com.example.stockwatcher.api.RetrofitClientInstance
import com.example.stockwatcher.api.models.News
import com.example.stockwatcher.api.models.NewsApiResponse
import com.example.stockwatcher.api.services.NewsApiService
import com.example.stockwatcher.databinding.FragmentNewsBinding
import com.example.stockwatcher.ui.adapters.NewsAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsFragment : Fragment(R.layout.fragment_news) {

    lateinit var binding: FragmentNewsBinding
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var newsApiService: NewsApiService
    var recyclerView: RecyclerView? = null;
    var adapter: NewsAdapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false )

        var recyclerView: RecyclerView = binding.newsRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)

        createService()
        getNews(binding.root.context)
        return binding.root
    }

    fun createService(){
        newsApiService = RetrofitClientInstance().instance()!!.create(NewsApiService::class.java)
    }

    fun getNews(context: Context) {
        var getNews = newsApiService.getNews("bitcoin")
        var disposable = getNews.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("Retrofit", "Success")
                processResponse(it)
            },{
                Log.d("Retrofit Error", "${it}")
            })

        compositeDisposable.add(disposable)
    }

    fun processResponse(response: NewsApiResponse){
        Log.d("Retrofit", "updating adapter")
        adapter.updateNewsDatastore(response.articles as ArrayList<News>)
        adapter.notifyDataSetChanged()
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
    }

}
