package com.example.core_domain.useCase

import com.example.core_domain.model.UserInfoDomainModel
import com.example.core_domain.repository.CoursesRepository

class SaveUserInfoUseCase(
    private val repository: CoursesRepository
) {
    suspend fun invoke(user: UserInfoDomainModel) {
        repository.saveUserInfo(user)
    }
}