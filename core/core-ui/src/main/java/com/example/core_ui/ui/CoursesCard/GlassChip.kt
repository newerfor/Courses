package com.example.core_ui.ui.CoursesCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.core_ui.constant.CoursesCardConstant.GLASS_BLUR_RADIUS
import com.example.core_ui.constant.CoursesCardConstant.GLASS_CHIP_CORNER
import com.example.core_ui.constant.CoursesCardConstant.GLASS_CHIP_PADDING_HORIZONTAL
import com.example.core_ui.constant.CoursesCardConstant.GLASS_CHIP_PADDING_VERTICAL
import com.example.core_ui.constant.CoursesCardConstant.GLASS_CHIP_SPACING
import com.example.core_ui.constant.CoursesCardConstant.GLASS_CIRCLE_BUTTON_SIZE
import com.example.core_ui.constant.CoursesCardConstant.GLASS_TINT_ALPHA
import com.example.core_ui.theme.GlassBackGroundColor
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeEffect

@Composable
fun GlassChip(
    hazeState: HazeState,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(GLASS_CHIP_CORNER))
            .hazeEffect(
                state = hazeState,
                style = HazeStyle(
                    backgroundColor = GlassBackGroundColor,
                    tints = listOf(HazeTint(GlassBackGroundColor.copy(alpha = GLASS_TINT_ALPHA))),
                    blurRadius = GLASS_BLUR_RADIUS
                )
            )
            .padding(
                horizontal = GLASS_CHIP_PADDING_HORIZONTAL,
                vertical = GLASS_CHIP_PADDING_VERTICAL
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(GLASS_CHIP_SPACING),
        content = content
    )
}

@Composable
fun GlassCircleButton(
    hazeState: HazeState,
    onClick: () -> Unit = {},
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .size(GLASS_CIRCLE_BUTTON_SIZE)
            .clip(CircleShape)
            .hazeEffect(
                state = hazeState,
                style = HazeStyle(
                    backgroundColor = GlassBackGroundColor,
                    tints = listOf(HazeTint(GlassBackGroundColor.copy(alpha = GLASS_TINT_ALPHA))),
                    blurRadius = GLASS_BLUR_RADIUS
                )
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
        content = content
    )
}