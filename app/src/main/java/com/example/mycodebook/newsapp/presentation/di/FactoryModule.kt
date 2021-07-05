package com.example.mycodebook.newsapp.presentation.di

import android.app.Application
import com.example.mycodebook.newsapp.domain.usecase.GetNewsHeadLinesUsecase
import com.example.mycodebook.newsapp.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideViewModelFactory(
        application: Application,
        getNewsHeadLinesUsecase: GetNewsHeadLinesUsecase
    ) : NewsViewModelFactory{

        return NewsViewModelFactory(application,getNewsHeadLinesUsecase)

    }

}