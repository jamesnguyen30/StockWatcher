package com.example.stockwatcher.data.models

data class Stock constructor(
        var tickerSymbol: String,
        var fullName: String,
        var value: Float,
        var change: Float
)