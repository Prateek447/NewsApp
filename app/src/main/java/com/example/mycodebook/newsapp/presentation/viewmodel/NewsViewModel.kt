package com.example.mycodebook.newsapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mycodebook.newsapp.data.model.ApiResponse
import com.example.mycodebook.newsapp.data.util.Resource
import com.example.mycodebook.newsapp.domain.usecase.GetNewsHeadLinesUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(
    val app : Application,
    private val getNewsHeadLinesUsecase: GetNewsHeadLinesUsecase
) : AndroidViewModel(app) {

    val newsHeadLines : MutableLiveData<Resource<ApiResponse>> =  MutableLiveData()

    fun getNewsHeadLines(country : String, page : Int) = viewModelScope.launch(Dispatchers.IO) {

        try {
            if (isNetworkAvailable(app)) {
                newsHeadLines.postValue(Resource.Loading())
                val apiResult = getNewsHeadLinesUsecase.execute(country, page)
                newsHeadLines.postValue(apiResult)
            } else {
                newsHeadLines.postValue(Resource.Error("Internet is not available"))
            }
        }
        catch (e : Exception){
            newsHeadLines.postValue(Resource.Error(e.message.toString()))
        }
    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }

}






