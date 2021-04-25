package com.example.stockwatcher.ui.fragments.searchStock

import com.example.stockwatcher.api.models.IEXSearchApiResponse
import com.example.stockwatcher.ui.base.BaseNavigator

interface SearchStockNavigator: BaseNavigator {
    fun processSearchResults(suggestedIEXSearches: List<IEXSearchApiResponse>)
}