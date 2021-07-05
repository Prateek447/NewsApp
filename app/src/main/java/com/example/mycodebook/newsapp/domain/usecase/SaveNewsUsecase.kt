package com.example.mycodebook.newsapp.domain.usecase

import com.example.mycodebook.newsapp.data.model.Article
import com.example.mycodebook.newsapp.domain.repository.NewsRepository

class SaveNewsUsecase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) =  newsRepository.saveNews(article)
}