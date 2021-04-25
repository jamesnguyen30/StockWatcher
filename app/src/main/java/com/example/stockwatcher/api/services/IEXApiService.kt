package com.example.stockwatcher.api.services

import com.example.stockwatcher.api.RetrofitClientInstance
import com.example.stockwatcher.api.models.IEXSearchApiResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface IEXApiService {
    @GET(RetrofitClientInstance.IEX_VERSION + "search/{query}")
    fun lookupTicker(@Path("query") query: String): Observable<List<IEXSearchApiResponse>>
}