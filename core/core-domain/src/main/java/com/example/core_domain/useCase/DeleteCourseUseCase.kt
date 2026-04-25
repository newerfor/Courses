package com.example.core_domain.useCase

import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.repository.CoursesRepository

class DeleteCourseUseCase(
    private val repository: CoursesRepository
) {
    suspend fun invoke(course: CoursesDomainModel) {
        repository.deleteCourses(course)
    }
}