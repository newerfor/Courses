package com.example.core_domain.useCase

import com.example.core_domain.model.UserInfoDomainModel
import com.example.core_domain.repository.CoursesRepository

class GetUserInfoUseCase(
    private val repository: CoursesRepository
) {
    suspend fun invoke(): Result<UserInfoDomainModel?> = runCatching {
        repository.getUserInfo()
    }
}