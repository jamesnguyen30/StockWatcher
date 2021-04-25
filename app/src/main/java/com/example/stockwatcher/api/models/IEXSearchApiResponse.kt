package com.example.stockwatcher.api.models

import com.google.gson.annotations.SerializedName

data class IEXSearchApiResponse(
        @SerializedName(value="symbol") var symbol: String,
        @SerializedName(value="cik") var cik: String,
        @SerializedName(value="securityName") var securityName: String,
        @SerializedName(value="securityType") var securityType: String,
        @SerializedName(value="region") var region: String,
        @SerializedName(value="exchange") var exchange: String,
        @SerializedName(value="sector") var sector: String,
        @SerializedName(value="currency") var currency: String
)
