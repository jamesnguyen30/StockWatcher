package com.example.stockwatcher.ui.base

interface BaseNavigator {
    fun showLoadingIndicator()
    fun hideLoadingIndicator()
    fun requestError()
}