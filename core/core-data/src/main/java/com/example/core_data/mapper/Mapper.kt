package com.example.core_data.mapper

import com.example.core_data.local.model.CoursesEntity
import com.example.core_data.local.model.UserEntity
import com.example.core_data.remote.model.CourseModel
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.model.UserInfoDomainModel

class Mapper {
    fun mapEntityToDomainUser(user: UserEntity): UserInfoDomainModel {
        return UserInfoDomainModel(
            email = user.email,
            password = user.password
        )
    }

    fun mapDomainToEntityUser(user: UserInfoDomainModel): UserEntity {
        return UserEntity(
            email = user.email,
            password = user.password
        )
    }

    fun mapModelToDomainCourse(
        course: CourseModel,
        imageIndex: Int,
        localHasLike: Boolean
    ): CoursesDomainModel {
        return CoursesDomainModel(
            id = course.id,
            title = course.title,
            text = course.text,
            price = course.price,
            rate = course.rate,
            startDate = course.startDate,
            hasLike = localHasLike,
            publishDate = course.publishDate,
            imageIndex = imageIndex
        )
    }

    fun mapEntityToDomainCourse(course: CoursesEntity): CoursesDomainModel {
        return CoursesDomainModel(
            id = course.id,
            title = course.title,
            text = course.text,
            price = course.price,
            rate = course.rate,
            startDate = course.startDate,
            hasLike = course.hasLike,
            publishDate = course.publishDate,
            imageIndex = course.image
        )
    }

    fun mapDomainToEntityCourse(course: CoursesDomainModel): CoursesEntity {
        return CoursesEntity(
            id = course.id,
            title = course.title,
            text = course.text,
            price = course.price,
            rate = course.rate,
            startDate = course.startDate,
            hasLike = course.hasLike,
            publishDate = course.publishDate,
            image = course.imageIndex
        )
    }

}