package com.example.core_domain.useCase

import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.repository.CoursesRepository

class GetCourseByIdUseCase(
    private val repository: CoursesRepository
) {
    suspend fun invoke(id: Int): Result<CoursesDomainModel?> = runCatching {
        repository.getCoursesById(id)
    }
}