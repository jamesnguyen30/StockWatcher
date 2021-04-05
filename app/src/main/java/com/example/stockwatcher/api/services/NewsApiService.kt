package com.example.stockwatcher.api.services

import com.example.stockwatcher.api.models.News
import com.example.stockwatcher.api.models.NewsApiResponse
import com.example.stockwatcher.data.models.Post
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApiService{
    @GET("/v2/everything")
    fun getNews(@Query("q") query: String): Observable<NewsApiResponse>
}