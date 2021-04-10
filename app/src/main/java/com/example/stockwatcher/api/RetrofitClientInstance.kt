package com.example.stockwatcher.api
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClientInstance {

    companion object{
        @JvmStatic
        private var retrofit: Retrofit? = null
        private val key = "65d060beb5aa4b30be79716bc3c6dbf1"
        private val baseUrl = "https://newsapi.org/here/"
        private val logger = HttpLoggingInterceptor()
        private val okHttpClient = OkHttpClient.Builder().addInterceptor{chain->

            var original = chain.request()
            var httpUrl = original.url

            var newUrl = httpUrl.newBuilder().addQueryParameter("apiKey", key).build()

            val newRequest = original.newBuilder().url(newUrl).build()
            chain.proceed(newRequest)
        }
    }

    fun instance():Retrofit?{
        if(retrofit==null) {

            logger.level = HttpLoggingInterceptor.Level.HEADERS

            val client = okHttpClient.addInterceptor(logger)
            client.connectTimeout(30, TimeUnit.SECONDS)

            retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .client(client.build())
                    .build()

        }
        return retrofit
    }


}
