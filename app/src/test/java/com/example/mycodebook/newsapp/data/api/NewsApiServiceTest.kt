package com.example.mycodebook.newsapp.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source

import org.junit.After


import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class NewsApiServiceTest {
    private lateinit var service: NewsApiService
     private lateinit var server : MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service =  Retrofit.Builder().baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory
                .create())
            .build().create(NewsApiService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }


    fun enqueuMockResponse(filename : String){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(filename)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadLines_sentRequest_receivedExpected(){
      runBlocking {
          enqueuMockResponse("newsResponse.json")
          val responseBody = service.getTopHeadLines("us",1).body()
          val request = server.takeRequest()
          assertThat(responseBody).isNotNull()
          assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=dcf0475276184f88842e15b624493e21")
      }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctPageSize(){
       runBlocking {
           enqueuMockResponse("newsResponse.json")
           val responseBody = service.getTopHeadLines("us",1).body()
           val request = server.takeRequest()
           val articleList = responseBody!!.articles
           assertThat(articleList.size).isEqualTo(20)
       }

    }

    @Test
    fun getTopHeadLines_receivedResponse_correctContent(){
        runBlocking {
            enqueuMockResponse("newsResponse.json")
            val responseBody = service.getTopHeadLines("us",1).body()
            val request = server.takeRequest()
            val articleList = responseBody!!.articles
            val article =  articleList[0]
            assertThat(article.author).isEqualTo("Vivian Wang, Alexandra Stevenson, Lam Yik Fei")
        }

    }
}