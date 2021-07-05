package com.example.mycodebook.newsapp.domain.usecase

import com.example.mycodebook.newsapp.data.model.ApiResponse
import com.example.mycodebook.newsapp.data.util.Resource
import com.example.mycodebook.newsapp.domain.repository.NewsRepository

class GetSearchedNewsUsecase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery : String) : Resource<ApiResponse>{
        return newsRepository.getSearchNews(searchQuery)
    }
}