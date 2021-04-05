package com.example.stockwatcher.api.models

import com.google.gson.annotations.SerializedName

data class News(
        @SerializedName(value="source") var source: NewsSource,
        @SerializedName(value="author") var author: String,
        @SerializedName(value="title") var title: String,
        @SerializedName(value="description") var description: String,
        @SerializedName(value="url") var url: String,
        @SerializedName(value="urlToImage") var urlToImage: String,
        @SerializedName(value="publishedAt") var rawPublishedDate: String,
        @SerializedName(value="content") var content: String
)