package com.example.feature_profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.core_ui.theme.BackgroundInput
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.theme.ProgressTextColor
import com.example.core_ui.ui.CourseLessonsCountText
import com.example.core_ui.ui.CourseTitleText
import com.example.feature_profile.costant.ProfileViewConstant.COURSE_END_SPACER
import com.example.feature_profile.costant.ProfileViewConstant.COURSE_TEXT_PADDING
import com.example.feature_profile.costant.ProfileViewConstant.COURSE_TEXT_PROGRESS_SPACER
import com.example.feature_profile.costant.ProfileViewConstant.COURSE_TEXT_SPACER
import com.example.feature_profile.costant.ProfileViewConstant.COURSE_TEXT_TO_PROGRESS_BAR_SPACER
import com.example.feature_profile.costant.ProfileViewConstant.PROGRESS_BAR_CLIP
import com.example.feature_profile.costant.ProfileViewConstant.PROGRESS_BAR_HEIGHT
import com.example.feature_profile.costant.ProfileViewConstant.PROGRESS_BAR_PADDING

@Composable
fun CoursesCardFirstProgressSpace(title: String) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = COURSE_TEXT_PADDING)
    ) {
        Spacer(Modifier.height(COURSE_TEXT_SPACER))
        CourseTitleText(
            text = title,
        )
        Spacer(Modifier.height(COURSE_TEXT_PROGRESS_SPACER))
        Row(Modifier.fillMaxWidth()) {
            Row(Modifier.weight(1f)) {
                CourseLessonsCountText("50%")
            }
            CourseLessonsCountText("22")
            CourseLessonsCountText("/44 уроков", ProgressTextColor)
        }
        Spacer(Modifier.height(COURSE_TEXT_TO_PROGRESS_BAR_SPACER))
        Row(Modifier.fillMaxWidth()) {
            Spacer(
                Modifier
                    .height(PROGRESS_BAR_HEIGHT)
                    .fillMaxWidth(0.5f)
                    .padding(end = PROGRESS_BAR_PADDING)
                    .clip(RoundedCornerShape(PROGRESS_BAR_CLIP))
                    .background(BrandGreen)
            )
            Spacer(
                Modifier
                    .height(PROGRESS_BAR_HEIGHT)
                    .weight(1f)
                    .clip(RoundedCornerShape(PROGRESS_BAR_CLIP))
                    .background(BackgroundInput)
            )
        }
        Spacer(Modifier.height(COURSE_END_SPACER))

    }
}

@Composable
fun CoursesCardSecondProgressSpace(title: String) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = COURSE_TEXT_PADDING)
    ) {
        Spacer(Modifier.height(COURSE_TEXT_SPACER))
        CourseTitleText(
            text = title,
        )
        Spacer(Modifier.height(COURSE_TEXT_PROGRESS_SPACER))
        Row(Modifier.fillMaxWidth()) {
            Row(Modifier.weight(1f)) {
                CourseLessonsCountText("30%")
            }
            CourseLessonsCountText("14")
            CourseLessonsCountText("/48 уроков", ProgressTextColor)
        }
        Spacer(Modifier.height(COURSE_TEXT_TO_PROGRESS_BAR_SPACER))
        Row(Modifier.fillMaxWidth()) {
            Spacer(
                Modifier
                    .height(PROGRESS_BAR_HEIGHT)
                    .fillMaxWidth(0.3f)
                    .padding(end = PROGRESS_BAR_PADDING)
                    .clip(RoundedCornerShape(PROGRESS_BAR_CLIP))
                    .background(BrandGreen)
            )
            Spacer(
                Modifier
                    .height(PROGRESS_BAR_HEIGHT)
                    .weight(1f)
                    .clip(RoundedCornerShape(PROGRESS_BAR_CLIP))
                    .background(BackgroundInput)
            )
        }
        Spacer(Modifier.height(COURSE_END_SPACER))

    }
}