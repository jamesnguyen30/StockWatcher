package com.example.stockwatcher.di.component

import com.example.stockwatcher.di.module.ViewModelModule
import com.example.stockwatcher.di.scope.FragmentScope
import com.example.stockwatcher.ui.fragments.news.NewsFragmentBottomSheet
import com.example.stockwatcher.ui.fragments.news.NewsFragment
import dagger.Component

@FragmentScope
@Component(modules = [ViewModelModule::class])
interface FragmentComponent {
    fun inject(newsFragment: NewsFragment)
    fun inject(newsFragmentBottomSheet: NewsFragmentBottomSheet)
}