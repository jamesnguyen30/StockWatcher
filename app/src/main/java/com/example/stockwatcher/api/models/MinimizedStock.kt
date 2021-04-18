package com.example.stockwatcher.api.models

import com.google.gson.annotations.SerializedName

data class MinimizedStock(
        var name: String,
        var value: Int,
        var change: Int
)