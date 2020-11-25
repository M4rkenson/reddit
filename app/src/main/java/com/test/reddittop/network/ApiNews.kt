package com.test.reddittop.network

import com.test.reddittop.models.News
import retrofit2.http.GET

interface ApiNews {
    @GET("top.json")
    suspend fun getTopNews(
    ): List<News>
}