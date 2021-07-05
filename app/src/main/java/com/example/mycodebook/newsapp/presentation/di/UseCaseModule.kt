package com.example.mycodebook.newsapp.presentation.di

import com.example.mycodebook.newsapp.domain.repository.NewsRepository
import com.example.mycodebook.newsapp.domain.usecase.GetNewsHeadLinesUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetNewsHeadLinesUseCase(
        newsRepository: NewsRepository
    ) :  GetNewsHeadLinesUsecase{
       return GetNewsHeadLinesUsecase(newsRepository)
    }


}