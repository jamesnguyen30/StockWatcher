package com.example.stockwatcher.api.services

import com.example.stockwatcher.api.RetrofitClientInstance
import com.example.stockwatcher.api.models.TickerApiResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TickerLookupApiService {
    @GET(RetrofitClientInstance.TICKER_LOOKUP_VERSION + "search")
    fun lookupTicker(@Query("query") query: String, @Query("limit") limit: String): Observable<List<TickerApiResponse>>
}