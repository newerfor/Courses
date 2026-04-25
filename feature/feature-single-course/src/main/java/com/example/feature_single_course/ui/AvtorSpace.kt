package com.example.feature_single_course.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.core_ui.ui.AuthorLabelText
import com.example.core_ui.ui.AuthorNameText
import com.example.feature_single_course.R
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_AVTOR_LOGO_CLIP
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_AVTOR_LOGO_SIZE
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_AVTOR_TEXT_SPACER

@Composable
fun AvtorSpace() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .size(COURSE_INFO_AVTOR_LOGO_SIZE)
                .clip(RoundedCornerShape(COURSE_INFO_AVTOR_LOGO_CLIP)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.avtor_logo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(Modifier.width(COURSE_INFO_AVTOR_TEXT_SPACER))
        Column {
            AuthorLabelText(stringResource(R.string.avtor_label))
            AuthorNameText("Merion Academy")
        }
    }
}