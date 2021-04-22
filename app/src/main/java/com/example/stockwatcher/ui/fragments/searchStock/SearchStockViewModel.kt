package com.example.stockwatcher.ui.fragments.searchStock

import android.util.Log
import com.example.stockwatcher.api.RetrofitClientInstance
import com.example.stockwatcher.api.services.TickerLookupApiService
import com.example.stockwatcher.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchStockViewModel: BaseViewModel<SearchStockNavigator>() {

    lateinit var lookupApiService: TickerLookupApiService

    init {
        start()
    }

    private fun start(){
       lookupApiService = RetrofitClientInstance().instanceTickerLookup()!!.create(TickerLookupApiService::class.java)
    }

    fun lookupTicker(searchTerm: String){
        var observable = lookupApiService.lookupTicker(searchTerm, "10")

        var disposable = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("SearchStockViewModel", it.toString())
                }, {
                    Log.d("SearchStockViewModel", it.toString())
                })

        addToDisposable(disposable)
    }
}