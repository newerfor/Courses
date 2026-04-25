package com.example.feature_profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.theme.LineColor
import com.example.core_ui.theme.TextPrimary
import com.example.core_ui.ui.ActionMenuItemText
import com.example.feature_profile.R
import com.example.feature_profile.costant.ProfileViewConstant.PROFILE_NAVIGATION_BOX_CLIP
import com.example.feature_profile.costant.ProfileViewConstant.PROFILE_NAVIGATION_BOX_PADDING
import com.example.feature_profile.costant.ProfileViewConstant.PROFILE_NAVIGATION_ICON_SIZE
import com.example.feature_profile.costant.ProfileViewConstant.PROFILE_NAVIGATION_LINE_SIZE
import com.example.feature_profile.costant.ProfileViewConstant.PROFILE_NAVIGATION_TEXT_TO_LINE_SPACER

@Composable
fun NavigationInProfile() {
    Column(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(PROFILE_NAVIGATION_BOX_CLIP))
            .background(BackgroundAvatar)
    ) {
        Column(Modifier
            .fillMaxWidth()
            .padding(horizontal = PROFILE_NAVIGATION_BOX_PADDING)) {
            Spacer(Modifier.height(PROFILE_NAVIGATION_TEXT_TO_LINE_SPACER))
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Row(Modifier.weight(1f)) {
                    ActionMenuItemText(stringResource(R.string.send_to_helper))
                }
                Icon(
                    painter = painterResource(R.drawable.right_arrow),
                    contentDescription = null,
                    tint = TextPrimary,
                    modifier = Modifier.size(PROFILE_NAVIGATION_ICON_SIZE)
                )

            }
            Spacer(Modifier.height(PROFILE_NAVIGATION_TEXT_TO_LINE_SPACER))

            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(PROFILE_NAVIGATION_LINE_SIZE)
                    .background(color = LineColor)
            )

            Spacer(Modifier.height(PROFILE_NAVIGATION_TEXT_TO_LINE_SPACER))
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Row(Modifier.weight(1f)) {
                    ActionMenuItemText(stringResource(R.string.go_to_setting))
                }
                Icon(
                    painter = painterResource(R.drawable.right_arrow),
                    contentDescription = null,
                    tint = TextPrimary,
                    modifier = Modifier.size(PROFILE_NAVIGATION_ICON_SIZE)
                )

            }
            Spacer(Modifier.height(PROFILE_NAVIGATION_TEXT_TO_LINE_SPACER))

            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(PROFILE_NAVIGATION_LINE_SIZE)
                    .background(color = LineColor)
            )

            Spacer(Modifier.height(PROFILE_NAVIGATION_TEXT_TO_LINE_SPACER))
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Row(Modifier.weight(1f)) {
                    ActionMenuItemText(stringResource(R.string.exit_account))
                }
                Icon(
                    painter = painterResource(R.drawable.right_arrow),
                    contentDescription = null,
                    tint = TextPrimary,
                    modifier = Modifier.size(PROFILE_NAVIGATION_ICON_SIZE)
                )

            }
            Spacer(Modifier.height(PROFILE_NAVIGATION_TEXT_TO_LINE_SPACER))
        }
    }
}