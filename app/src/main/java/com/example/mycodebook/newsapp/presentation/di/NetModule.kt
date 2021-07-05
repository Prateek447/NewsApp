package com.example.mycodebook.newsapp.presentation.di

import com.example.mycodebook.newsapp.BuildConfig
import com.example.mycodebook.newsapp.data.api.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetModule {

      @Singleton
      @Provides
      fun provideRetrofit() : Retrofit{
          return Retrofit.Builder()
              .addConverterFactory(GsonConverterFactory
                  .create())
              .baseUrl(BuildConfig.BASE_URL)
              .build()
      }


    @Singleton
    @Provides
    fun provideAPIService( retrofit: Retrofit) : NewsApiService{
        return retrofit.create(NewsApiService::class.java)
    }

}