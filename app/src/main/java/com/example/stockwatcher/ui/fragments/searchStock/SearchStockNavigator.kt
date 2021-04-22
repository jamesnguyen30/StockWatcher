package com.example.stockwatcher.ui.fragments.searchStock

import com.example.stockwatcher.api.models.LookupApiResponse

interface SearchStockNavigator {

    fun processSearchResults(suggestedTickers: List<LookupApiResponse>)
    fun showLoadingIndicator()
    fun hideLoadingIndicator()
    fun requestError()
}