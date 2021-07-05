package com.example.mycodebook.newsapp.data.model

data class ApiResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)