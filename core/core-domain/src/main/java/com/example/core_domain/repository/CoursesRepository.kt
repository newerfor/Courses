package com.example.core_domain.repository

import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.model.UserInfoDomainModel

interface CoursesRepository {
    suspend fun getUserInfo(): UserInfoDomainModel
    suspend fun saveUserInfo(user: UserInfoDomainModel)
    suspend fun getAllCourses(): List<CoursesDomainModel>
    suspend fun deleteCourses(courses: CoursesDomainModel)
    suspend fun getCoursesByLike(): List<CoursesDomainModel>
    suspend fun saveCourses(courses: CoursesDomainModel)
    suspend fun getCoursesById(id: Int): CoursesDomainModel?
}