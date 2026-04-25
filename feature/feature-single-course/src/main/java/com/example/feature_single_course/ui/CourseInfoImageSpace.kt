package com.example.feature_single_course.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.core_domain.model.CoursesDomainModel
import com.example.core_ui.theme.Background
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.theme.TextPrimary
import com.example.core_ui.ui.CourseInfoChipText
import com.example.core_ui.ui.CoursesCard.GlassChip
import com.example.core_ui.ui.dateHelperIntToString
import com.example.core_viewmodel.courses_viewModel.CoursesViewModel
import com.example.feature_single_course.R
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_BUTTON_ICON_CLIP
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_BUTTON_ICON_OFFSET
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_BUTTON_ICON_SIZE
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_BUTTON_PADDING
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_INFO_BOX_ICON_STAR_SIZE
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_INFO_BOX_PADDING
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_INFO_BOX_SPACER
import com.example.feature_single_course.constant.CourseInfoViewConstant.COURSE_INFO_IMAGE_SIZE
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState

@Composable
fun CourseInfoImageSpace(
    course: CoursesDomainModel,
    coursesViewModel: CoursesViewModel,
    onCLickBack: () -> Unit
) {
    var isLiked = remember { mutableStateOf(false) }
    val hazeState = rememberHazeState()
    val imageList = listOf(
        painterResource(R.drawable.three_course_image),
        painterResource(R.drawable.courses_image),
        painterResource(R.drawable.second_course_image),
    )
    Box(
        Modifier
            .fillMaxWidth()
            .height(COURSE_INFO_IMAGE_SIZE)
    ) {
        Image(
            painter = imageList[course.imageIndex],
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .hazeSource(state = hazeState),
            contentScale = ContentScale.Crop,
        )
        Row(
            Modifier
                .fillMaxWidth()
                .systemBarsPadding()
                .padding(COURSE_INFO_IMAGE_BUTTON_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .size(COURSE_INFO_IMAGE_BUTTON_ICON_SIZE)
                    .clip(RoundedCornerShape(COURSE_INFO_IMAGE_BUTTON_ICON_CLIP))
                    .background(TextPrimary)
                    .clickable {
                        onCLickBack.invoke()
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.arrow_go_back),
                    contentDescription = null,
                    tint = Background,
                    modifier = Modifier
                        .offset(y = COURSE_INFO_IMAGE_BUTTON_ICON_OFFSET)
                )
            }

            Box(
                Modifier
                    .size(COURSE_INFO_IMAGE_BUTTON_ICON_SIZE)
                    .clip(RoundedCornerShape(COURSE_INFO_IMAGE_BUTTON_ICON_CLIP))
                    .background(TextPrimary)
                    .clickable {
                        if (isLiked.value) {
                            isLiked.value = false
                            coursesViewModel.deleteCourse(
                                CoursesDomainModel(
                                    id = course.id,
                                    title = course.title,
                                    text = course.text,
                                    price = course.price,
                                    rate = course.rate,
                                    startDate = course.startDate,
                                    hasLike = isLiked.value,
                                    publishDate = course.publishDate,
                                    imageIndex = course.imageIndex,
                                )
                            )
                        } else {
                            isLiked.value = true
                            coursesViewModel.saveCourse(
                                CoursesDomainModel(
                                    id = course.id,
                                    title = course.title,
                                    text = course.text,
                                    price = course.price,
                                    rate = course.rate,
                                    startDate = course.startDate,
                                    hasLike = isLiked.value,
                                    publishDate = course.publishDate,
                                    imageIndex = course.imageIndex,
                                )
                            )
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = if (isLiked.value) {
                        painterResource(R.drawable.book_mark_courses_info_filled)
                    } else {
                        painterResource(R.drawable.book_mark_courses_info)
                    },
                    contentDescription = null,
                    tint = if (isLiked.value) BrandGreen else Background,
                    modifier = Modifier
                        .offset(y = COURSE_INFO_IMAGE_BUTTON_ICON_OFFSET)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(COURSE_INFO_IMAGE_INFO_BOX_PADDING),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            GlassChip(hazeState) {
                Icon(
                    painter = painterResource(com.example.core_ui.R.drawable.star),
                    contentDescription = null,
                    tint = BrandGreen,
                    modifier = Modifier.size(COURSE_INFO_IMAGE_INFO_BOX_ICON_STAR_SIZE)
                )
                CourseInfoChipText(text = course.rate)
            }
            Spacer(Modifier.width(COURSE_INFO_IMAGE_INFO_BOX_SPACER))
            GlassChip(hazeState) {
                CourseInfoChipText(text = dateHelperIntToString(course.startDate))
            }
        }
    }
}