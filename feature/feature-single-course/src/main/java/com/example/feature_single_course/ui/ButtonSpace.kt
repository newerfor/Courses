package com.example.feature_single_course.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.ui.ButtonLabelText
import com.example.feature_single_course.R
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_BUTTON_HEIGHT
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_BUTTON_TEXT_FONT_SIZE
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_BUTTON_TO_BUTTON_SPACER

@Composable
fun ButtonSpace() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(COURSE_INFO_BUTTON_HEIGHT),
        colors = ButtonDefaults.buttonColors(
            containerColor = BrandGreen
        ),
    ) {
        ButtonLabelText(
            stringResource(R.string.button_text_start_course),
            fontSize = COURSE_INFO_BUTTON_TEXT_FONT_SIZE
        )
    }
    Spacer(Modifier.height(COURSE_INFO_BUTTON_TO_BUTTON_SPACER))

    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(COURSE_INFO_BUTTON_HEIGHT),
        colors = ButtonDefaults.buttonColors(
            containerColor = BackgroundAvatar
        ),
    ) {
        ButtonLabelText(
            stringResource(R.string.button_text_go_to_platform),
            fontSize = COURSE_INFO_BUTTON_TEXT_FONT_SIZE
        )
    }
}