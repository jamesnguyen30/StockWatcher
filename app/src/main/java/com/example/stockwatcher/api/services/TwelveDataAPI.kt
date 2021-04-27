package com.example.stockwatcher.api.services

import com.example.stockwatcher.api.config.TwelveDataAPIConfig
import com.example.stockwatcher.api.models.SearchResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TwelveDataAPI {
    @GET(TwelveDataAPIConfig.SEARCH_ENDPOINT)
    fun symbolSearch(@Query("symbol") symbol: String): Observable<SearchResponse>
}