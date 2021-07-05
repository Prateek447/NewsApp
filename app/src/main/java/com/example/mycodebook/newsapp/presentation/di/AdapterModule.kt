package com.example.mycodebook.newsapp.presentation.di

import com.example.mycodebook.newsapp.presentation.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideNewsAdapter() : NewsAdapter{
        return  NewsAdapter()
    }
}