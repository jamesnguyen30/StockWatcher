package com.example.stockwatcher.di.module

import com.example.stockwatcher.di.scope.FragmentScope
import com.example.stockwatcher.ui.fragments.news.NewsViewModel
import dagger.Module
import dagger.Provides

@Module
public class ViewModelModule{

    @Provides
    @FragmentScope
    fun provideNewsViewModel(): NewsViewModel{
        return NewsViewModel()
    }

}