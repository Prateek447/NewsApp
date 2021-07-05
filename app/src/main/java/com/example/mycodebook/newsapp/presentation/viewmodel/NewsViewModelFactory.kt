package com.example.mycodebook.newsapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycodebook.newsapp.domain.usecase.GetNewsHeadLinesUsecase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadLinesUsecase: GetNewsHeadLinesUsecase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadLinesUsecase
        ) as T
    }
}