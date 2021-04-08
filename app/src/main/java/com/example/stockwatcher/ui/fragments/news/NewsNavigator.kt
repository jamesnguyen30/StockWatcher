package com.example.stockwatcher.ui.fragments.news

import com.example.stockwatcher.api.models.News
import com.example.stockwatcher.api.models.NewsApiResponse

interface NewsNavigator {

    fun processResponse(response: NewsApiResponse);
    fun handleError(error: Throwable)
}