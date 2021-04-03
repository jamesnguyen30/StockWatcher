package com.example.stockwatcher.data.repository

import com.example.stockwatcher.data.models.RetroPhoto
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService  {

    @GET("/photos")
    fun getAllPhotos(): Call<List<RetroPhoto>>;
}