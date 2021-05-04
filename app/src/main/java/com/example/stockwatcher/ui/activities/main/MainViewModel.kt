package com.example.stockwatcher.ui.activities.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stockwatcher.api.RetrofitClientInstance
import com.example.stockwatcher.api.config.TwelveDataAPIConfig
import com.example.stockwatcher.api.models.StockQuote
import com.example.stockwatcher.api.models.TimeSeriesResponse
import com.example.stockwatcher.api.services.TwelveDataAPI
import com.example.stockwatcher.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable.interval
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainViewModel : BaseViewModel<MainNavigator>(){

    lateinit var twelveDataAPI: TwelveDataAPI

//    private var stockQuoteDataStore: Map<String, StockQuote>? = null
//    private var timeSeriesDataStore: Map<String, TimeSeriesResponse>? = null

    val stockQuoteLiveData: MutableLiveData<Map<String, StockQuote>> = MutableLiveData()
    val timeSeriesLiveData: MutableLiveData<Map<String, TimeSeriesResponse>> = MutableLiveData()

    var symbolList: List<String>?=null

    private fun createFetchingObservable(intervalInMilliseconds: Long = 10000){
        var disposable =
                interval(500, intervalInMilliseconds, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            getQuotes()
                            //TODO timeSeriesLiveData isn't called to save API request count
                        }
        addToDisposable(disposable)
    }

    private fun getQuotes(){
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
//                            stockQuoteDataStore = it
                            stockQuoteLiveData.value = it
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
//                            stockQuoteDataStore = mapOf(symbolList[0] to it)
                            stockQuoteLiveData.value = mapOf(symbolList[0] to it)
                        }, {
                            handleError(it)
                        })
            }
            addToDisposable(dispoable)
        }
    }

    private fun getTimeSeries(){
        symbolList?.let { symbolList ->
            var listToString = symbolList.joinToString(",")
            var dispoable: Disposable

            if (symbolList.size > 1) {
                dispoable = twelveDataAPI.timeSeriesQuoteBatch(listToString, TwelveDataAPIConfig.INTERVAL.ONE_DAY.value)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            timeSeriesLiveData.value = it
                        }, {
                            handleError(it)
                        })
            } else {
                dispoable = twelveDataAPI.timeSeriesQuote(listToString, TwelveDataAPIConfig.INTERVAL.ONE_DAY.value)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            timeSeriesLiveData.value = mapOf(symbolList[0] to it)
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

        createFetchingObservable()
    }

    fun stopFetchingData(){
        clearDisposables()
    }

    fun handleQuoteResponse(response: StockQuote){

    }

    fun handleError(throwable: Throwable){
        Log.d("MainViewModel Error", throwable.toString())
    }




}