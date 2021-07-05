package com.example.mycodebook.newsapp.presentation.di

import com.example.mycodebook.newsapp.data.api.NewsApiService
import com.example.mycodebook.newsapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.mycodebook.newsapp.data.repository.dataSourceImp.NewsRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsApiService: NewsApiService
    ) : NewsRemoteDataSource {
        return NewsRemoteDataSourceImp(newsApiService)
    }

}