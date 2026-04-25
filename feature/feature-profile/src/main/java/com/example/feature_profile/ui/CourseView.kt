package com.example.feature_profile.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.ui.CoursesCard.CardImageSpace
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_profile.costant.ProfileViewConstant.CLIP_COURSE_CARD
import com.example.feature_profile.costant.ProfileViewConstant.SPACER_COURSE_CARD

@Composable
fun CourseView(courseList: List<CoursesDomainModel>, coursesViewModel: CoursesViewModel) {
    Column(Modifier.fillMaxSize()) {
        courseList.forEachIndexed { index, course ->
            CourseCardScreen(
                course = course,
                coursesViewModel,
                index
            )
            Spacer(Modifier.height(SPACER_COURSE_CARD))
        }
    }
}

@Composable
fun CourseCardScreen(course: CoursesDomainModel, coursesViewModel: CoursesViewModel, index: Int) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(CLIP_COURSE_CARD))
            .background(BackgroundAvatar)
    ) {
        CardImageSpace(
            course,
            coursesViewModel
        )
        when (index) {
            0 -> CoursesCardFirstProgressSpace(course.title)
            1 -> CoursesCardSecondProgressSpace(course.title)
            else -> CoursesCardFirstProgressSpace(course.title)
        }
    }
}

