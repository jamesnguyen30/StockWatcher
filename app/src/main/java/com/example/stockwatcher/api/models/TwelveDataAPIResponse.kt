package com.example.stockwatcher.api.models

import com.google.gson.annotations.SerializedName

data class SearchResponse(
        @SerializedName(value="data") var data: List<SearchSymbol>,
        @SerializedName(value="status") var status: String
)

data class TimeSeriesResponse(
        @SerializedName(value="meta") var meta: TimeSeriesMeta,
        @SerializedName(value="values") var values: List<TimeSeriesValue>,
        @SerializedName(value="status") var status: String
)

data class TimeSeriesMeta(
        @SerializedName("currency")
        val currency: String,
        @SerializedName("exchange")
        val exchange: String,
        @SerializedName("exchange_timezone")
        val exchangeTimezone: String,
        @SerializedName("interval")
        val interval: String,
        @SerializedName("symbol")
        val symbol: String,
        @SerializedName("type")
        val type: String
)
data class TimeSeriesValue(
        @SerializedName("close")
        val close: String,
        @SerializedName("datetime")
        val datetime: String,
        @SerializedName("high")
        val high: String,
        @SerializedName("low")
        val low: String,
        @SerializedName("open")
        val `open`: String,
        @SerializedName("volume")
        val volume: String
)

data class SearchSymbol(
        @SerializedName(value="symbol") var symbol: String,
        @SerializedName(value="instrument_name") var instrumentName: String,
        @SerializedName(value="exchange") var exchange: String,
        @SerializedName(value="exchange_timezone") var exchangeTimeZone: String,
        @SerializedName(value="instrument_type") var exchangeType: String,
        @SerializedName(value="country") var country: String,
        @SerializedName(value="currency") var currency: String
)

data class Exchange(
        @SerializedName(value="name") var name: String,
        @SerializedName(value="code") var code: String,
        @SerializedName(value="country") var country: String,
        @SerializedName(value="timezone") var timezone: String
)

data class StockQuote(
        @SerializedName("average_volume") val averageVolume: String,
        @SerializedName("change") val change: String,
        @SerializedName("close") val close: String,
        @SerializedName("currency") val currency: String,
        @SerializedName("datetime") val datetime: String,
        @SerializedName("exchange") val exchange: String,
        @SerializedName("fifty_two_week") val fiftyTwoWeek: FiftyTwoWeek,
        @SerializedName("high") val high: String,
        @SerializedName("low") val low: String,
        @SerializedName("name") val name: String,
        @SerializedName("open") val open: String,
        @SerializedName("percent_change") val percentChange: String,
        @SerializedName("previous_close") val previousClose: String,
        @SerializedName("symbol") val symbol: String,
        @SerializedName("volume") val volume: String
)

data class FiftyTwoWeek(
        @SerializedName("high") val high: String,
        @SerializedName("high_change") val highChange: String,
        @SerializedName("high_change_percent") val highChangePercent: String,
        @SerializedName("low") val low: String,
        @SerializedName("low_change") val lowChange: String,
        @SerializedName("low_change_percent") val lowChangePercent: String,
        @SerializedName("range") val range: String
)
