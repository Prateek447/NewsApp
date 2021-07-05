package com.example.mycodebook.newsapp.presentation.di

import com.example.mycodebook.newsapp.data.repository.NewsRepositoryImp
import com.example.mycodebook.newsapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.mycodebook.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
     fun provideNewsRepository(
         newsRemoteDataSource: NewsRemoteDataSource
     ) : NewsRepository{
         return NewsRepositoryImp(newsRemoteDataSource);
     }

}