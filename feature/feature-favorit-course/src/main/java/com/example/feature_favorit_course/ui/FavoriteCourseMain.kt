package com.example.feature_favorit_course.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.core_ui.theme.Background
import com.example.core_ui.ui.CoursesUIState
import com.example.core_ui.ui.NavigationBar
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_favorit_course.constant.FavoriteCourseViewConstant.LABEL_TEXT_PADDING
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteCourseMain(navController: NavController, onClickCourse: (Int) -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .systemBarsPadding()
    ) {
        Column(Modifier.weight(1f)) {
            FavoriteCourseView(
                onClickCourse = onClickCourse
            )
        }
        Column {
            NavigationBar(
                navController = navController,
            )
        }
    }
}

@Composable
fun FavoriteCourseView(
    coursesViewModel: CoursesViewModel = koinViewModel(),
    onClickCourse: (Int) -> Unit
) {
    val coursesUiState by coursesViewModel.coursesUiState.collectAsState()
    var isFirstLoad = remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        if (isFirstLoad.value) {
            isFirstLoad.value = false
            coursesViewModel.getCoursesByLike()
        }
    }

    Column(Modifier
        .fillMaxSize()
        .padding(top = LABEL_TEXT_PADDING)) {
        CoursesUIState(
            coursesUiState = coursesUiState,
            onSuccess = { courses ->
                FavoriteCourseMainScreen(
                    courses = courses,
                    coursesViewModel = coursesViewModel,
                    onClickCourse
                )
            },
            onRetryClick = {
                coursesViewModel.getCoursesByLike()
            }
        )
    }
}