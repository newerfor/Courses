package com.example.feature_favorit_course.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.ui.CoursesCard.CoursesView
import com.example.core_ui.ui.TitleText
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_favorit_course.R
import com.example.feature_favorit_course.constant.FavoriteCourseViewConstant.LABEL_TEXT_PADDING

@Composable
fun FavoriteCourseMainScreen(
    courses: List<CoursesDomainModel>,
    coursesViewModel: CoursesViewModel,
    onClickCourse: (Int) -> Unit,
) {
    Column(Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Column(Modifier.padding(horizontal = LABEL_TEXT_PADDING)) {
            TitleText(stringResource(R.string.favorit_label_text))
        }
        Spacer(Modifier.height(LABEL_TEXT_PADDING))
        CoursesView(
            courses = courses,
            coursesViewModel = coursesViewModel,
            {
                coursesViewModel.getCoursesByLike()
            },
            onClickCourse = onClickCourse,
        )
    }
}