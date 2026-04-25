package com.example.core_data.remote.api

import com.example.core_data.constant.ApiConstant.BASE_URL
import com.example.core_data.constant.ApiConstant.SECOND_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val mainInstance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    val secondInstance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(SECOND_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}