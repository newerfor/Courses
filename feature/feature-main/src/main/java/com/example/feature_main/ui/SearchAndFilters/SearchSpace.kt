package com.example.feature_main.ui.SearchAndFilters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.theme.Roboto
import com.example.core_ui.theme.TextPrimary
import com.example.core_ui.ui.InputPlaceholderText
import com.example.feature_main.R
import com.example.feature_main.constant.MainViewConstant.TEXT_FIELD_BOX_SIZE_ICON
import com.example.feature_main.constant.MainViewConstant.TEXT_FIELD_FONT_SIZE
import com.example.feature_main.constant.MainViewConstant.TEXT_FIELD_HEIGHT
import com.example.feature_main.constant.MainViewConstant.TEXT_FIELD_ICON_PACER
import com.example.feature_main.constant.MainViewConstant.TEXT_FIELD_ICON_SIZE
import com.example.feature_main.constant.MainViewConstant.TEXT_FIELD_LETTER_SPACING
import com.example.feature_main.constant.MainViewConstant.TEXT_FIELD_LINE_HEIGHT
import com.example.feature_main.constant.MainViewConstant.TEXT_FIELD_PADDING
import com.example.feature_main.constant.MainViewConstant.TEXT_FIELD_SHAPE

@Composable
fun SearchSpace() {
    var searchCourses = remember { mutableStateOf("") }

    BasicTextField(
        value = searchCourses.value,
        onValueChange = { newNameCourse ->
            searchCourses.value = newNameCourse
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(TEXT_FIELD_HEIGHT),
        textStyle = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = TEXT_FIELD_FONT_SIZE,
            lineHeight = TEXT_FIELD_LINE_HEIGHT,
            letterSpacing = TEXT_FIELD_LETTER_SPACING,
            color = TextPrimary
        ),
        singleLine = true,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = BackgroundAvatar,
                        shape = RoundedCornerShape(TEXT_FIELD_SHAPE)
                    )
                    .padding(horizontal = TEXT_FIELD_PADDING),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.size(TEXT_FIELD_BOX_SIZE_ICON),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.search),
                        contentDescription = null,
                        tint = TextPrimary,
                        modifier = Modifier.size(TEXT_FIELD_ICON_SIZE)
                    )
                }
                Spacer(Modifier.width(TEXT_FIELD_ICON_PACER))
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (searchCourses.value.isEmpty()) {
                        InputPlaceholderText(text = stringResource(R.string.input_place_holder_text))
                    }
                    innerTextField()
                }
            }
        }
    )
}