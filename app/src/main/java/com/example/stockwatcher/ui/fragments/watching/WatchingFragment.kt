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
import com.example.stockwatcher.data.models.RetroPhoto
import com.example.stockwatcher.data.repository.GetDataService
import com.example.stockwatcher.data.repository.RetrofitClientInstance
import com.example.stockwatcher.ui.activities.MainActivity
import com.example.stockwatcher.ui.adapters.StockRVAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WatchingFragment : Fragment() {

    lateinit var getDataService: GetDataService
    var recyclerView: RecyclerView? = null;

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
        retrofitGetPhotos(view.context)

        return view;
    }

    fun createService(){
       getDataService = RetrofitClientInstance.retrofit.create(GetDataService::class.java)
    }

    fun retrofitGetPhotos(context: Context){
        var call: Call<List<RetroPhoto>> = getDataService.getAllPhotos()

        call.enqueue(object: Callback<List<RetroPhoto>> {
            override fun onFailure(call: Call<List<RetroPhoto>>?, t: Throwable?) {
                Toast.makeText(context, "Can't call API", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<RetroPhoto>>?,
                response: Response<List<RetroPhoto>>?
            ) {

                processResponse(response!!.body())
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun processResponse(photos: List<RetroPhoto>){
        Log.d("Retrofit", "Photo instance" + photos[0].toString())
    }

}