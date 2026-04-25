package com.example.core_data.remote.remoteRepository

import com.example.core_data.remote.model.CoursesModel

interface RemoteDataSource {
    suspend fun getCoursesRemote(): CoursesModel
}