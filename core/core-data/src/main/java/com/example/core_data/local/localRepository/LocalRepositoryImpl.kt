package com.example.core_data.local.localRepository

import com.example.core_data.local.dao.CoursesDao
import com.example.core_data.local.model.CoursesEntity
import com.example.core_data.local.model.UserEntity

class LocalRepositoryImpl(
    private val dao: CoursesDao,
) : LocalDataSource {
    override suspend fun getLikedCourses(): List<CoursesEntity> {
        return dao.getLikedCourse()
    }

    override suspend fun saveCourse(course: CoursesEntity) {
        dao.saveCourse(course)
    }

    override suspend fun deleteCourse(course: CoursesEntity) {
        dao.deleteCourse(course)
    }

    override suspend fun saveUser(user: UserEntity) {
        dao.saveUser(user)
    }

    override suspend fun getUser(): UserEntity {
        return dao.getUser()
    }

}