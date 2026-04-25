package com.example.feature_main.ui.SearchAndFilters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.theme.TextPrimary
import com.example.feature_main.R
import com.example.feature_main.constant.MainViewConstant.BUTTON_FILTERS_CLIP
import com.example.feature_main.constant.MainViewConstant.BUTTON_FILTERS_SIZE
import com.example.feature_main.constant.MainViewConstant.BUTTON_ICON_SIZE

@Composable
fun SearchFiltersSpace() {
    Box(
        Modifier
            .size(BUTTON_FILTERS_SIZE)
            .clip(RoundedCornerShape(BUTTON_FILTERS_CLIP))
            .background(BackgroundAvatar), contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.filters_icon),
            contentDescription = null,
            tint = TextPrimary,
            modifier = Modifier.size(BUTTON_ICON_SIZE)
        )
    }
}