package com.example.core_ui.ui.CoursesCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.R
import com.example.core_ui.constant.CoursesCardConstant.BOTTOM_SPACER_HEIGHT
import com.example.core_ui.constant.CoursesCardConstant.BUTTON_ICON_SPACER_WIDTH
import com.example.core_ui.constant.CoursesCardConstant.DESCRIPTION_TO_PRICE_SPACER_HEIGHT
import com.example.core_ui.constant.CoursesCardConstant.HORIZONTAL_PADDING
import com.example.core_ui.constant.CoursesCardConstant.ICON_OFFSET_Y
import com.example.core_ui.constant.CoursesCardConstant.TITLE_TO_DESCRIPTION_SPACER_HEIGHT
import com.example.core_ui.constant.CoursesCardConstant.TOP_SPACER_HEIGHT
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.ui.CourseDescriptionText
import com.example.core_ui.ui.CourseMoreButtonText
import com.example.core_ui.ui.CoursePriceText
import com.example.core_ui.ui.CourseTitleText

@Composable
fun CardTextSpace(
    course: CoursesDomainModel,
    onClickCourse: (Int) -> Unit,

    ) {
    Column(Modifier
        .fillMaxWidth()
        .padding(horizontal = HORIZONTAL_PADDING)) {
        Spacer(Modifier.height(TOP_SPACER_HEIGHT))
        CourseTitleText(text = course.title)
        Spacer(Modifier.height(TITLE_TO_DESCRIPTION_SPACER_HEIGHT))
        CourseDescriptionText(text = course.text)
        Spacer(Modifier.height(DESCRIPTION_TO_PRICE_SPACER_HEIGHT))
        Row {
            CoursePriceText(text = "${course.price} ${stringResource(R.string.rubles_icon)}")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClickCourse.invoke(course.id)
                    },
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CourseMoreButtonText(text = stringResource(R.string.courses_card_button_text))
                Spacer(Modifier.width(BUTTON_ICON_SPACER_WIDTH))
                Icon(
                    painter = painterResource(R.drawable.arrow_right),
                    contentDescription = null,
                    tint = BrandGreen,
                    modifier = Modifier.offset(y = ICON_OFFSET_Y)
                )
            }
        }
        Spacer(Modifier.height(BOTTOM_SPACER_HEIGHT))
    }
}