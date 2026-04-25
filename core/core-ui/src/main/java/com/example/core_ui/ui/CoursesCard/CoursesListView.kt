package com.example.core_ui.ui.CoursesCard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.constant.CoursesCardConstant.CARD_HORIZONTAL_PADDING
import com.example.core_ui.constant.CoursesCardConstant.CARD_SPACER_HEIGHT
import com.example.core_ui.ui.EmptyMessage
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel

@Composable
fun CoursesView(
    courses: List<CoursesDomainModel>,
    coursesViewModel: CoursesViewModel,
    onClickReload: () -> Unit,
    onClickCourse: (Int) -> Unit,
) {
    Column(Modifier.fillMaxSize()) {
        Column(Modifier
            .fillMaxSize()
            .padding(horizontal = CARD_HORIZONTAL_PADDING)) {
            for (course in courses) {
                CoursesCard(
                    course = course,
                    coursesViewModel = coursesViewModel,
                    onClickCourse
                )
                Spacer(Modifier.height(CARD_SPACER_HEIGHT))
            }
        }
        Column() {
            EmptyMessage(
                onButtonClick = onClickReload,
            )
        }
    }
}