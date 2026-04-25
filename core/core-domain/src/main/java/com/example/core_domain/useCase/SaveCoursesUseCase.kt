package com.example.core_domain.useCase

import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.repository.CoursesRepository

class SaveCoursesUseCase(
    private val repository: CoursesRepository
) {
    suspend fun invoke(courses: CoursesDomainModel) {
        repository.saveCourses(courses)
    }
}