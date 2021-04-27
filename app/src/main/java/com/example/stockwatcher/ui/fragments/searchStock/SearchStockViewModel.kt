package com.example.stockwatcher.ui.fragments.searchStock

import com.example.stockwatcher.api.RetrofitClientInstance
import com.example.stockwatcher.api.services.TwelveDataAPI
import com.example.stockwatcher.ui.base.BaseViewModel
import com.jakewharton.rxrelay3.PublishRelay
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SearchStockViewModel: BaseViewModel<SearchStockNavigator>() {

    lateinit var symbolSearchService: TwelveDataAPI
    private val tickerAutoCompletePublishSubject =  PublishRelay.create<String>()

    fun init(navigator: SearchStockNavigator){
        symbolSearchService = RetrofitClientInstance().stockReferenceRetrofitInstance()!!.create(TwelveDataAPI::class.java)
        setNavigator(navigator)
        configureAutoCompletePublishRelay()
    }

    private fun configureAutoCompletePublishRelay(){
        tickerAutoCompletePublishSubject
                .debounce(300, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .switchMap {
                    symbolSearchService.symbolSearch(it)
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