package com.example.mycodebook.newsapp.data.api

import com.example.mycodebook.newsapp.BuildConfig
import com.example.mycodebook.newsapp.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadLines(
        @Query("country")
         country : String,
        @Query("page")
        page : Int,
        @Query("apiKey")
        apiKey : String = BuildConfig.API_KEY
    ) : Response<ApiResponse>
}