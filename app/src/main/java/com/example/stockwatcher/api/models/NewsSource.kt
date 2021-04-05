package com.example.stockwatcher.api.models

import com.google.gson.annotations.SerializedName

data class NewsSource(
       @SerializedName(value="id") var id: String,
       @SerializedName(value="name") var name: String
)