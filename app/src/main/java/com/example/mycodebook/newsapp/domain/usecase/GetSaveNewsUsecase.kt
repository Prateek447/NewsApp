package com.example.mycodebook.newsapp.domain.usecase

import com.example.mycodebook.newsapp.data.model.Article
import com.example.mycodebook.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSaveNewsUsecase(private val newsRepository: NewsRepository) {
     fun execute() : Flow<List<Article>>{
         return newsRepository.getSavedNews()
     }
}