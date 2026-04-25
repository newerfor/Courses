package com.example.core_data.remote.remoteRepository

import android.util.Log
import com.example.core_data.remote.api.ApiService
import com.example.core_data.remote.model.CoursesModel

class RemoteRepositoryImpl(
    private val apiService: ApiService,
    private val secondApiService: ApiService
) : RemoteDataSource {

    override suspend fun getCoursesRemote(): CoursesModel {
        return try {
            apiService.getCourses()
        } catch (e: Exception) {
            try {
                secondApiService.getCoursesSecondApi()
            } catch (e2: Exception) {
                throw Exception("Оба API недоступны: ${e.message}, ${e2.message}")
            }
        }
    }
}