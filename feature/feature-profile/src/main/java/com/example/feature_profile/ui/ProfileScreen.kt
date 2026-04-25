package com.example.feature_profile.ui

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
import com.example.core_ui.ui.TitleText
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_profile.R
import com.example.feature_profile.costant.ProfileViewConstant.PROFILE_SCREEN_BOX_PADDING

@Composable
fun ProfileScreen(courseList: List<CoursesDomainModel>, coursesViewModel: CoursesViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = PROFILE_SCREEN_BOX_PADDING)
            .verticalScroll(rememberScrollState())
    ) {
        TitleText(stringResource(R.string.label_text))
        Spacer(Modifier.height(PROFILE_SCREEN_BOX_PADDING))
        NavigationInProfile()
        Spacer(Modifier.height(PROFILE_SCREEN_BOX_PADDING))
        TitleText(stringResource(R.string.second_label_text))
        Spacer(Modifier.height(PROFILE_SCREEN_BOX_PADDING))
        CourseView(courseList, coursesViewModel)
    }
}