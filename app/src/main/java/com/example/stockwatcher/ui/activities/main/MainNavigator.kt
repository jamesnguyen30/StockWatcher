package com.example.stockwatcher.ui.activities.main

import com.example.stockwatcher.ui.base.BaseNavigator

interface MainNavigator: BaseNavigator {
    fun stockDataIsUpdated()
}