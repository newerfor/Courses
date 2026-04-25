package com.example.feature_single_course.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.core_ui.theme.Background
import com.example.core_ui.ui.CoursesUIState
import com.example.core_ui.ui.NavigationBar
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_single_course.constant.CourseInfoLogicConstant.GET_COURSE_INDEX
import org.koin.androidx.compose.koinViewModel

@Composable
fun CourseInfoMain(navController: NavController, id: Int, onCLickBack: () -> Unit) {
    Column(Modifier
        .fillMaxSize()
        .background(Background)
        .navigationBarsPadding()) {
        Column(Modifier.weight(1f)) {
            CourseInfoView(id = id, onCLickBack = onCLickBack)
        }
        Column {
            NavigationBar(
                navController = navController,
            )
        }
    }

}

@Composable
fun CourseInfoView(
    coursesViewModel: CoursesViewModel = koinViewModel(),
    id: Int,
    onCLickBack: () -> Unit
) {
    val coursesUiState by coursesViewModel.coursesUiState.collectAsState()
    LaunchedEffect(Unit) {
        coursesViewModel.getCoursesById(id)
    }
    Column(Modifier.fillMaxSize()) {
        CoursesUIState(coursesUiState, onSuccess = { courses ->
            CourseInfoScreen(courses[GET_COURSE_INDEX], coursesViewModel, onCLickBack)
        }) {
            coursesViewModel.getAllCourses()
        }
    }
}