package com.example.mycodebook.newsapp.data.repository.dataSourceImp

import com.example.mycodebook.newsapp.data.api.NewsApiService
import com.example.mycodebook.newsapp.data.model.ApiResponse
import com.example.mycodebook.newsapp.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImp(
    private val newsApiService: NewsApiService,
) : NewsRemoteDataSource {
    override suspend fun getTopHeadLines( country : String,page : Int): Response<ApiResponse> {
        return newsApiService.getTopHeadLines(country, page)
    }
}