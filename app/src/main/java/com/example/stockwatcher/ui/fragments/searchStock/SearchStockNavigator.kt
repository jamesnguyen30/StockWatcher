package com.example.stockwatcher.ui.fragments.searchStock

import com.example.stockwatcher.api.models.TickerApiResponse

interface SearchStockNavigator {

    fun processSearchResults(suggestedTickers: List<TickerApiResponse>)
    fun showLoadingIndicator()
    fun hideLoadingIndicator()
    fun requestError()
}