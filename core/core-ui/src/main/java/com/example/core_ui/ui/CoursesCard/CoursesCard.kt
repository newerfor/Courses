package com.example.core_ui.ui.CoursesCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.constant.CoursesCardConstant.CARD_CORNER_RADIUS
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel

@Composable
fun CoursesCard(
    course: CoursesDomainModel,
    coursesViewModel: CoursesViewModel,
    onClickCourse: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(CARD_CORNER_RADIUS))
            .background(BackgroundAvatar)
    ) {
        CardImageSpace(
            course,
            coursesViewModel
        )
        CardTextSpace(
            course = course,
            onClickCourse
        )
    }
}