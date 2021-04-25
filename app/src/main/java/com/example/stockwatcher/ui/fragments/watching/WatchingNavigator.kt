package com.example.stockwatcher.ui.fragments.watching

import com.example.stockwatcher.data.models.Stock
import com.example.stockwatcher.ui.base.BaseNavigator

interface WatchingNavigator: BaseNavigator{
    fun processResults(response: List<Stock>)
}