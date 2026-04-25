package com.example.core_domain.useCase

import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.repository.CoursesRepository

class GetAllCoursesUseCase(
    private val repository: CoursesRepository
) {
    suspend fun invoke(): Result<List<CoursesDomainModel>> = runCatching {
        repository.getAllCourses()
    }
}