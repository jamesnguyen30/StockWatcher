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
import com.example.stockwatcher.api.MockAPIService
import com.example.stockwatcher.api.RetrofitClientInstance
import com.example.stockwatcher.data.models.Post
import com.example.stockwatcher.ui.adapters.StockRVAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class WatchingFragment : Fragment() {

    lateinit var mockApiService: MockAPIService
    var recyclerView: RecyclerView? = null;
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        createService()
        var view = inflater.inflate(R.layout.fragment_watching, container, false)
        recyclerView = view.findViewById(R.id.stock_recycler_view)
        recyclerView!!.adapter = StockRVAdapter()
        recyclerView!!.layoutManager = LinearLayoutManager(view.context)

        getPosts(view.context)
        return view;
    }

    fun createService(){
       mockApiService = RetrofitClientInstance.retrofit.create(MockAPIService::class.java)
    }

    fun getPosts(context: Context) {
        var getPost = mockApiService.getPosts()
        var disposable = getPost.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
               processResponse(it)
            },{
                Toast.makeText(context, "Error calling API.\n${it}", Toast.LENGTH_SHORT).show()
            })

        compositeDisposable.add(disposable)
    }

    fun processResponse(posts: List<Post>){
        Log.d("Retrofit", "Photo instance" + posts[0].toString())
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
    }

}