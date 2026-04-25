package com.example.core_viewmodel.di

import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.core_viewmodel.userInfo_viewModel.UserInfoViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { UserInfoViewModel(get(), get()) }
    viewModel { CoursesViewModel(get(), get(), get(), get(), get()) }
}