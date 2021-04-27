package com.example.stockwatcher.ui.fragments.searchStock

import com.example.stockwatcher.api.models.SearchResponse
import com.example.stockwatcher.ui.base.BaseNavigator

interface SearchStockNavigator: BaseNavigator {
    fun processSearchResults(suggestedSearches: SearchResponse)
}