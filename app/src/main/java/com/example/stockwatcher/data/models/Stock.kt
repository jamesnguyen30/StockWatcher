package com.example.stockwatcher.data.models

data class Stock(
        var ticker: String,
        var instrumentName: String,
        var exchangeTimeZone: String,
        var exchange: String,
        var currency: String,
        var country: String,

        var change: Float
)

