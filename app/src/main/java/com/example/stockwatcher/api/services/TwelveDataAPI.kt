package com.example.stockwatcher.api.services

import com.example.stockwatcher.api.config.TwelveDataAPIConfig
import com.example.stockwatcher.api.models.SearchResponse
import com.example.stockwatcher.api.models.StockQuote
import com.example.stockwatcher.api.models.TimeSeriesResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TwelveDataAPI {
    @GET(TwelveDataAPIConfig.SEARCH_ENDPOINT)
    fun symbolSearch(@Query("symbol") symbol: String): Observable<SearchResponse>

    @GET(TwelveDataAPIConfig.TIME_SERIES_ENDPOINT)
    fun timeSeriesQuoteBatch(@Query("symbol") symbol: String, @Query("interval") interval: String): Observable<Map<String,TimeSeriesResponse>>

    @GET(TwelveDataAPIConfig.TIME_SERIES_ENDPOINT)
    fun timeSeriesQuote(@Query("symbol") symbol: String, @Query("interval") interval: String): Observable<TimeSeriesResponse>

    @GET(TwelveDataAPIConfig.QUOTE_ENDPOINT)
    fun quoteBatch(@Query("symbol") symbol: String): Observable<Map<String, StockQuote>>

    @GET(TwelveDataAPIConfig.QUOTE_ENDPOINT)
    fun quote(@Query("symbol") symbol: String): Observable<StockQuote>
}