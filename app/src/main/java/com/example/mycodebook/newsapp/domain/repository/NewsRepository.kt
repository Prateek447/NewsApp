package com.example.mycodebook.newsapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.mycodebook.newsapp.data.model.ApiResponse
import com.example.mycodebook.newsapp.data.model.Article
import com.example.mycodebook.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow


interface NewsRepository {

    suspend fun getNewsLinesHeadLines(country : String, page : Int) : Resource<ApiResponse>
    suspend fun getSearchNews(searchQuery: String) : Resource<ApiResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews() : Flow<List<Article>>


}