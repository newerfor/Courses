package com.example.core_ui.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_viewmodel.courses_viewModel.CoursesUIState

@Composable
fun CoursesUIState(
    coursesUiState: CoursesUIState,
    onSuccess: @Composable (List<CoursesDomainModel>) -> Unit,
    onRetryClick: () -> Unit
) {
    when (coursesUiState) {
        is CoursesUIState.Error -> {
            ErrorMessage(onRetryClick)
        }

        is CoursesUIState.Success -> {
            onSuccess.invoke(coursesUiState.courses)
        }

        is CoursesUIState.Loading -> {
            LoadRound()
        }
    }
}