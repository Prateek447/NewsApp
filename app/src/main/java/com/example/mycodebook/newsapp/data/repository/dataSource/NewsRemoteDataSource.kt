package com.example.mycodebook.newsapp.data.repository.dataSource

import com.example.mycodebook.newsapp.data.model.ApiResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadLines(country : String, page : Int) : Response<ApiResponse>
}