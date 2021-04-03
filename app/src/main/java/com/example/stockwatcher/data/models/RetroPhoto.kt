package com.example.stockwatcher.data.models

import com.google.gson.annotations.SerializedName

data class RetroPhoto(
    @SerializedName("albumId") var albumId: Integer,
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("url") var url: String,
    @SerializedName("thumbnailUrl") var thumbnailUrl: String
) {
}