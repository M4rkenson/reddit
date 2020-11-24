package com.test.reddittop.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ClientService {
    @GET
    fun getData(@Url url:String): Call<Any>
}