package com.example.core_viewmodel.courses_viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_domain.useCase.DeleteCourseUseCase
import com.example.core_domain.useCase.GetAllCoursesUseCase
import com.example.core_domain.useCase.GetCourseByIdUseCase
import com.example.core_domain.useCase.GetCoursesByLikeUseCase
import com.example.core_domain.useCase.SaveCoursesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CoursesViewModel(
    private val getAllCoursesUseCase: GetAllCoursesUseCase,
    private val getCoursesByLikeUseCase: GetCoursesByLikeUseCase,
    private val saveCoursesUseCase: SaveCoursesUseCase,
    private val getCourseByIdUseCase: GetCourseByIdUseCase,
    private val deleteCourseUseCase: DeleteCourseUseCase
) : ViewModel() {
    private val _coursesUiState = MutableStateFlow<CoursesUIState>(CoursesUIState.Loading)
    val coursesUiState: StateFlow<CoursesUIState> = _coursesUiState.asStateFlow()
    private var coursesInfo = mutableListOf<CoursesDomainModel>()
    fun getAllCourses() {
        viewModelScope.launch {
            _coursesUiState.value = CoursesUIState.Loading
            val result = getAllCoursesUseCase.invoke()
            result.onSuccess { courses ->
                coursesInfo.addAll(courses)
                _coursesUiState.value = CoursesUIState.Success(courses)
            }.onFailure { error ->
                _coursesUiState.value = CoursesUIState.Error
            }
        }
    }

    fun getCoursesByLike() {
        viewModelScope.launch {
            _coursesUiState.value = CoursesUIState.Loading
            val result = getCoursesByLikeUseCase.invoke()
            result.onSuccess { courses ->
                _coursesUiState.value = CoursesUIState.Success(courses)
            }.onFailure { error ->
                _coursesUiState.value = CoursesUIState.Error
            }
        }
    }

    fun isSorted() {
        _coursesUiState.value = CoursesUIState.Loading
        _coursesUiState.value =
            CoursesUIState.Success(coursesInfo.sortedByDescending { it.publishDate })
    }

    fun saveCourse(course: CoursesDomainModel) {
        viewModelScope.launch {
            saveCoursesUseCase.invoke(course)
        }
    }

    fun deleteCourse(course: CoursesDomainModel) {
        viewModelScope.launch {
            deleteCourseUseCase.invoke(course)
        }
    }

    fun getCoursesById(id: Int) {
        viewModelScope.launch {
            _coursesUiState.value = CoursesUIState.Loading
            val result = getCourseByIdUseCase.invoke(id)
            result.onSuccess { courses ->
                if (courses != null) {
                    _coursesUiState.value = CoursesUIState.Success(listOf(courses))
                } else {
                    _coursesUiState.value = CoursesUIState.Error
                }
            }.onFailure { error ->
                _coursesUiState.value = CoursesUIState.Error
            }
        }
    }
}