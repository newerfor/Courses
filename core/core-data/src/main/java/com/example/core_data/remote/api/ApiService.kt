package com.example.core_data.remote.api

import com.example.core_data.remote.model.CoursesModel
import retrofit2.http.GET

interface ApiService {
    @GET("uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun getCourses(): CoursesModel

    @GET("EffectiveMobileFakeApi/db")
    suspend fun getCoursesSecondApi(): CoursesModel
}