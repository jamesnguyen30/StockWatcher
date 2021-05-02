package com.example.stockwatcher.ui.activities.main

import android.util.Log
import com.example.stockwatcher.api.RetrofitClientInstance
import com.example.stockwatcher.api.config.TwelveDataAPIConfig
import com.example.stockwatcher.api.models.StockQuote
import com.example.stockwatcher.api.models.TimeSeriesResponse
import com.example.stockwatcher.api.services.TwelveDataAPI
import com.example.stockwatcher.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel : BaseViewModel<MainNavigator>(){

    lateinit var twelveDataAPI: TwelveDataAPI

    private var stockQuoteDataStore: Map<String, StockQuote>? = null
    private var timeSeriesDataStore: Map<String, TimeSeriesResponse>? = null

    var symbolList: List<String>?=null
        get() = field
        set(value){
            field=value
        }

    fun getQuotes(){
        symbolList?.let {
            symbolList->
            var listToString = symbolList!!.joinToString(",")
            var dispoable: Disposable

            if (symbolList.size > 1) {
                dispoable = twelveDataAPI
                        .quoteBatch(listToString)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            Log.d("MainViewModel", it.toString())
                            stockQuoteDataStore = it
                        }, {
                            handleError(it)
                        })
            } else {
                dispoable = twelveDataAPI
                        .quote(listToString)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            Log.d("MainViewModel", it.toString())
                            var soleItem = symbolList[0]
                            stockQuoteDataStore = mapOf(soleItem to it)
                        }, {
                            handleError(it)
                        })
            }

            addToDisposable(dispoable)
        }
    }

    fun getTimeSeries(){
        symbolList?.let { symbolList ->
            var listToString = symbolList.joinToString(",")
            var dispoable: Disposable

            if (symbolList.size > 1) {
                dispoable = twelveDataAPI.timeSeriesQuoteBatch(listToString, TwelveDataAPIConfig.INTERVAL.ONE_DAY.value)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            timeSeriesDataStore = it
                        }, {
                            handleError(it)
                        })
            } else {
                dispoable = twelveDataAPI.timeSeriesQuote(listToString, TwelveDataAPIConfig.INTERVAL.ONE_DAY.value)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            timeSeriesDataStore = mapOf(symbolList[0] to it)
                        }, {
                            handleError(it)
                        })
            }

            addToDisposable(dispoable)
        }
    }

    @Throws(Exception::class)
    fun startFetchingData(){
        if(symbolList ==null || symbolList!!.isEmpty()){
           throw java.lang.Exception("Symbol List is 0")
        }
        navigator ?: throw java.lang.Exception("MainNavigator is null in MainViewHolder")

        twelveDataAPI = RetrofitClientInstance().stockReferenceRetrofitInstance()!!.create(TwelveDataAPI::class.java)
        getQuotes()
        getTimeSeries()
    }

    fun handleQuoteResponse(response: StockQuote){

    }

    fun handleError(throwable: Throwable){
        Log.d("MainViewModel Error", throwable.toString())
    }



}