package com.example.feature_main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.constant.CoursesCardConstant.CARD_HORIZONTAL_PADDING
import com.example.core_ui.ui.CoursesCard.CoursesView
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_main.constant.MainViewConstant.SPACER_FILTER_TO_COURSES_CARD
import com.example.feature_main.ui.SearchAndFilters.SearchAndFiltersScreen

@Composable
fun MainScreen(
    courses: List<CoursesDomainModel>,
    coursesViewModel: CoursesViewModel,
    onClickCourse: (Int) -> Unit,
) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Column(Modifier.padding(horizontal = CARD_HORIZONTAL_PADDING)) {
            SearchAndFiltersScreen(coursesViewModel)
        }
        Spacer(Modifier.height(SPACER_FILTER_TO_COURSES_CARD))
        CoursesView(courses, coursesViewModel, {
            coursesViewModel.getAllCourses()
        }, onClickCourse)
    }
}