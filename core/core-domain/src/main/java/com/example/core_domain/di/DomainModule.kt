package com.example.core_domain.di

import com.example.core_domain.useCase.DeleteCourseUseCase
import com.example.core_domain.useCase.GetAllCoursesUseCase
import com.example.core_domain.useCase.GetCourseByIdUseCase
import com.example.core_domain.useCase.GetCoursesByLikeUseCase
import com.example.core_domain.useCase.GetUserInfoUseCase
import com.example.core_domain.useCase.SaveCoursesUseCase
import com.example.core_domain.useCase.SaveUserInfoUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetUserInfoUseCase(get()) }
    factory { GetCourseByIdUseCase(get()) }
    factory { SaveUserInfoUseCase(get()) }
    factory { GetAllCoursesUseCase(get()) }
    factory { SaveCoursesUseCase(get()) }
    factory { GetCoursesByLikeUseCase(get()) }
    factory { DeleteCourseUseCase(get()) }
}