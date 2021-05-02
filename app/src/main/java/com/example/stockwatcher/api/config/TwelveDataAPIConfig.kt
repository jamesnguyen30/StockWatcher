package com.example.stockwatcher.api.config

class TwelveDataAPIConfig{
    //TUTORIAL https://twelvedata.com/blog/first-introduction-getting-an-advantage-in-a-few-minutes
    //HOMEPAGE: https://twelvedata.com
    enum class INTERVAL(val value: String){
        ONE_MIN("1min"),
        FIVE_MIN("5min"),
        FIFTEEN_MIN("15min"),
        THIRTY_MIN("30min"),
        FORTY_FIVE_MIN("45min"),
        ONE_HOUR("1hour"),
        TWO_HOUR("2hour"),
        FOUR_HOUR("4hour"),
        ONE_DAY("1day"),
        ONE_WEEK("1week"),
        ONE_MONTH("1month")
    }

    companion object{
        const val BASE_URL = "https://api.twelvedata.com"
        const val TIME_SERIES_ENDPOINT = "time_series"
        const val SEARCH_ENDPOINT = "symbol_search"
        const val QUOTE_ENDPOINT = "quote"
        const val API_KEY = "9ddbc69cb8c24a7792d48f9ed9af3745"

    }
}