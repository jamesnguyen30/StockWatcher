package com.example.stockwatcher.api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.example.stockwatcher.api.config.TwelveDataAPIConfig
import com.example.stockwatcher.api.config.NewsAPIConfig

class RetrofitClientInstance {

    companion object{
        @JvmStatic
        private var retrofit: Retrofit? = null

        @JvmStatic
        private var retrofitTickerLookup: Retrofit? = null

//        private val key = "65d060beb5aa4b30be79716bc3c6dbf1"
//        private val baseUrl = "https://newsapi.org/here/"

    }

    fun instance():Retrofit?{
        val logger = HttpLoggingInterceptor()
        val okHttpClient = constructOkClientBuilder(mapOf("apiKey" to NewsAPIConfig.KEY))
        if(retrofit==null) {

            logger.level = HttpLoggingInterceptor.Level.HEADERS

            val client = okHttpClient.addInterceptor(logger)
            client.connectTimeout(30, TimeUnit.SECONDS)

            retrofit = Retrofit.Builder()
                    .baseUrl(NewsAPIConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .client(client.build())
                    .build()
        }
        return retrofit
    }

    fun stockReferenceRetrofitInstance(): Retrofit?{
        val logger = HttpLoggingInterceptor()
        val okHttpClient = constructOkClientBuilder(mapOf("apikey" to TwelveDataAPIConfig.API_KEY))
        if(retrofitTickerLookup==null) {

            logger.level = HttpLoggingInterceptor.Level.HEADERS

            val client = okHttpClient.addInterceptor(logger)
            client.connectTimeout(30, TimeUnit.SECONDS)

            retrofitTickerLookup = Retrofit.Builder()
                    .baseUrl(TwelveDataAPIConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .client(client.build())
                    .build()
        }
        return retrofitTickerLookup
    }

    private fun constructOkClientBuilder(dict: Map<String, String> ): OkHttpClient.Builder{
         val okHttpClient = OkHttpClient.Builder().addInterceptor{chain->

            var original = chain.request()
            var newUrl = original.url

             var newUrlBuilder = newUrl.newBuilder()
             dict.forEach{
                 key,value->
                 newUrlBuilder.addQueryParameter(key, value)
             }

             newUrl = newUrlBuilder.build()

            val newRequest = original.newBuilder().url(newUrl).build()
            chain.proceed(newRequest)
        }
        return  okHttpClient
    }


}
