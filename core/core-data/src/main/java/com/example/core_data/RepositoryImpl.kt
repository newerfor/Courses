package com.example.core_data

import com.example.core_data.local.localRepository.LocalDataSource
import com.example.core_data.mapper.Mapper
import com.example.core_data.remote.remoteRepository.RemoteDataSource
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.model.UserInfoDomainModel
import com.example.core_domain.repository.CoursesRepository

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val mapper: Mapper
) : CoursesRepository {
    override suspend fun getUserInfo(): UserInfoDomainModel {
        return mapper.mapEntityToDomainUser(localDataSource.getUser())
    }

    override suspend fun saveUserInfo(user: UserInfoDomainModel) {
        localDataSource.saveUser(mapper.mapDomainToEntityUser(user))
    }

    override suspend fun getAllCourses(): List<CoursesDomainModel> {
        val result = remoteDataSource.getCoursesRemote()
        val localResult = getCoursesByLike()
        return result.courses.map { course ->
            var localHasLike = course.hasLike
            localResult.forEach { localCourse ->
                if (localCourse.id == course.id) {
                    localHasLike = localCourse.hasLike
                }
            }
            if (course.hasLike) {
                saveCourses(mapper.mapModelToDomainCourse(course, course.id % 3, localHasLike))
            }
            mapper.mapModelToDomainCourse(course, course.id % 3, localHasLike)
        }
    }

    override suspend fun deleteCourses(courses: CoursesDomainModel) {
        localDataSource.deleteCourse(mapper.mapDomainToEntityCourse(courses))
    }

    override suspend fun getCoursesByLike(): List<CoursesDomainModel> {
        return localDataSource.getLikedCourses().map { course ->
            mapper.mapEntityToDomainCourse(course)
        }
    }

    override suspend fun saveCourses(courses: CoursesDomainModel) {
        localDataSource.saveCourse(mapper.mapDomainToEntityCourse(courses))
    }

    override suspend fun getCoursesById(id: Int): CoursesDomainModel? {
        val apiResult = remoteDataSource.getCoursesRemote()
        return apiResult.courses.find { it.id == id }?.let {
            mapper.mapModelToDomainCourse(
                it,
                it.id % 3,
                it.hasLike
            )
        }
    }
}