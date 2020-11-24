package com.test.reddittop.network

import android.content.ContentValues.TAG
import android.util.Log
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    fun retrofitService():ApiNews {
        val retrofit = Retrofit.Builder().baseUrl("http://www.reddit.com/").addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(ClientService::class.java)
        service?.getData("http://www.reddit.com/top.json")
            ?.enqueue(object : Callback<Any> {
                override fun onFailure(call: Call<Any>, t: Throwable) {

                }

                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    Log.e(TAG, "" + Gson().toJson(response))
                    if (response.isSuccessful) {
                        println("Success")
                    }

                }
            })}
}
