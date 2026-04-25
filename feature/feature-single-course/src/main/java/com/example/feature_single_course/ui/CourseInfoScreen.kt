package com.example.feature_single_course.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.ui.AboutTitleText
import com.example.core_ui.ui.AuthorLabelText
import com.example.core_ui.ui.AuthorNameText
import com.example.core_ui.ui.ButtonLabelText
import com.example.core_ui.ui.CourseDescriptionText
import com.example.core_ui.ui.CourseTitleLargeText
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_single_course.R
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_AVTOR_LOGO_CLIP
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_AVTOR_LOGO_SIZE
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_AVTOR_TEXT_SPACER
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_AVTOR_TO_BUTTON_SPACER
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_BUTTON_HEIGHT
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_BUTTON_TEXT_FONT_SIZE
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_BUTTON_TO_BUTTON_SPACER
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_BUTTON_TO_COURSE_INFO_LABEL_SPACER
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_COURSE_INFO_LABEL_TO_INFO_SPACER
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_DESCRIPTION_TEXT_FONT_SIZE
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_DESCRIPTION_TEXT_LETTERSPACING
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_DESCRIPTION_TEXT_LINE_HEIGHT
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_PADDING
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_TEXT_SPACER

@Composable
fun CourseInfoScreen(
    courses: CoursesDomainModel,
    coursesViewModel: CoursesViewModel,
    onCLickBack: () -> Unit
) {
    Column(Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        CourseInfoImageSpace(courses, coursesViewModel, onCLickBack)
        Column(Modifier.padding(horizontal = COURSE_INFO_PADDING)) {
            Spacer(Modifier.height(COURSE_INFO_TEXT_SPACER))
            CourseTitleLargeText(courses.title)
            Spacer(Modifier.height(COURSE_INFO_TEXT_SPACER))
            AvtorSpace()
            Spacer(Modifier.height(COURSE_INFO_AVTOR_TO_BUTTON_SPACER))
            ButtonSpace()
            Spacer(Modifier.height(COURSE_INFO_BUTTON_TO_COURSE_INFO_LABEL_SPACER))
            AboutTitleText(stringResource(R.string.cours_info_text))
            Spacer(Modifier.height(COURSE_INFO_COURSE_INFO_LABEL_TO_INFO_SPACER))
            CourseDescriptionText(
                text = courses.text,
                maxLine = Int.MAX_VALUE,
                fontSize = COURSE_INFO_DESCRIPTION_TEXT_FONT_SIZE,
                lineHeight = COURSE_INFO_DESCRIPTION_TEXT_LINE_HEIGHT,
                letterSpacing = COURSE_INFO_DESCRIPTION_TEXT_LETTERSPACING
            )
        }

    }
}