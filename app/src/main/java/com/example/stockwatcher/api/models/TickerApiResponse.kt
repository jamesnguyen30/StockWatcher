package com.example.stockwatcher.api.models

import com.google.gson.annotations.SerializedName

data class TickerApiResponse(
        @SerializedName(value="symbol") var symbol: String,
        @SerializedName(value="name") var name: String,
        @SerializedName(value="currency") var currency: String,
        @SerializedName(value="stockExchange") var stockExchange: String,
        @SerializedName(value="exchangeShortName") var exchangeShortName: String
)
