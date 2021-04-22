package com.example.stockwatcher.ui.fragments.searchStock

import com.example.stockwatcher.api.RetrofitClientInstance
import com.example.stockwatcher.api.services.TickerLookupApiService
import com.example.stockwatcher.ui.base.BaseViewModel
import com.jakewharton.rxrelay3.PublishRelay
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SearchStockViewModel: BaseViewModel<SearchStockNavigator>() {

    lateinit var lookupApiService: TickerLookupApiService
    private val tickerAutoCompletePublishSubject =  PublishRelay.create<String>()

    fun init(navigator: SearchStockNavigator){
        lookupApiService = RetrofitClientInstance().instanceTickerLookup()!!.create(TickerLookupApiService::class.java)
        setNavigator(navigator)
        configureAutoCompletePublishRelay()
    }

    private fun configureAutoCompletePublishRelay(){
        tickerAutoCompletePublishSubject
                .debounce(300, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .switchMap {
                    lookupApiService.lookupTicker(it, "10")
                }
            .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    getNavigator()!!.processSearchResults(it)
                }, {
                    getNavigator()!!.requestError()
                })
    }

    fun lookupTicker(query: String){
        tickerAutoCompletePublishSubject.accept(query.trim())
    }
}