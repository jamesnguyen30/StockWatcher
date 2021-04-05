package com.example.stockwatcher.api.models

import com.google.gson.annotations.SerializedName

data class NewsApiResponse(
    @SerializedName(value="status") var status: String,
    @SerializedName(value="totalResults") var totalResults: Int,
    @SerializedName(value="articles") var articles: List<News>
)