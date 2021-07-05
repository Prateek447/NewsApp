package com.example.mycodebook.newsapp.domain.usecase

import com.example.mycodebook.newsapp.data.model.ApiResponse
import com.example.mycodebook.newsapp.data.util.Resource
import com.example.mycodebook.newsapp.domain.repository.NewsRepository

class GetNewsHeadLinesUsecase(private val newsRepository: NewsRepository) {

    suspend fun execute(country : String, page : Int) : Resource<ApiResponse>{
        return newsRepository.getNewsLinesHeadLines(country, page)
    }
}