package com.example.feature_login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import com.example.core_ui.theme.LineColor
import com.example.feature_login.R
import com.example.feature_login.constant.LoginLogicConstant.OK_LINK
import com.example.feature_login.constant.LoginLogicConstant.VK_LINK
import com.example.feature_login.constant.LoginViewConstant.GRAY_LINE_HEIGHT
import com.example.feature_login.constant.LoginViewConstant.SOCIAL_MEDIA_IMAGE_PADDING
import com.example.feature_login.constant.LoginViewConstant.SPACER_DONT_HAVE_ACCOUNT_TEXT_TO_SOCIAL_MEDIA_LINE

@Composable
fun SocialMediaButtons() {
    val uriHandler = LocalUriHandler.current
    Spacer(Modifier
        .fillMaxWidth()
        .height(GRAY_LINE_HEIGHT)
        .background(color = LineColor))
    Spacer(Modifier.height(SPACER_DONT_HAVE_ACCOUNT_TEXT_TO_SOCIAL_MEDIA_LINE))
    Row(Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.vk),
            contentDescription = "VK",
            modifier = Modifier
                .weight(1f)
                .padding(end = SOCIAL_MEDIA_IMAGE_PADDING)
                .clickable {
                    uriHandler.openUri(VK_LINK)
                },
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.odnoklassniki),
            contentDescription = "Odnoklassniki",
            modifier = Modifier
                .weight(1f)
                .padding(start = SOCIAL_MEDIA_IMAGE_PADDING)
                .clickable {
                    uriHandler.openUri(OK_LINK)
                },
            contentScale = ContentScale.Crop
        )
    }
}