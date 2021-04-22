package com.example.stockwatcher.ui.fragments.searchStock

interface SearchStockNavigator {

    fun processSearchResults()
    fun loadingRequest()
    fun stopLoadingRequest()
    fun requestError()
}