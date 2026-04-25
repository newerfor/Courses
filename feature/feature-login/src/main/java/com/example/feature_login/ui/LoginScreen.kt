package com.example.feature_login.ui

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import com.example.core_ui.theme.TextPrimary
import com.example.core_ui.ui.ActionLinkText
import com.example.core_ui.ui.LoginTitleText
import com.example.core_viewmodel.userInfo_viewModel.UserInfoViewModel
import com.example.feature_login.R
import com.example.feature_login.constant.LoginViewConstant.LOGIN_SCREEN_PADDING_HORIZONTAL
import com.example.feature_login.constant.LoginViewConstant.SPACER_DONT_HAVE_ACCOUNT_TEXT
import com.example.feature_login.constant.LoginViewConstant.SPACER_DONT_HAVE_ACCOUNT_TEXT_TO_SOCIAL_MEDIA_LINE
import com.example.feature_login.constant.LoginViewConstant.SPACER_INPUT_TEXT_TO_DONT_HAVE_ACCOUNT_TEXT
import com.example.feature_login.constant.LoginViewConstant.SPACER_LABEL_LOGIN_TO_INPUT_SPACE

@Composable
fun LoginScreen(isLoginTrue: () -> Unit, userViewModel: UserInfoViewModel) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(Modifier
        .padding(horizontal = LOGIN_SCREEN_PADDING_HORIZONTAL)
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
                keyboardController?.hide()
            })
        }) {
        LoginTitleText(
            text = stringResource(R.string.login_label),
        )
        Spacer(Modifier.height(SPACER_LABEL_LOGIN_TO_INPUT_SPACE))
        InputSpace(isLoginTrue, userViewModel)
        Spacer(Modifier.height(SPACER_INPUT_TEXT_TO_DONT_HAVE_ACCOUNT_TEXT))
        Column(Modifier.fillMaxWidth(), Arrangement.Center, Alignment.CenterHorizontally) {
            Row() {
                ActionLinkText(
                    text = "${stringResource(R.string.dont_have_account_text)} ",
                    textColor = TextPrimary
                )
                ActionLinkText(
                    text = stringResource(R.string.go_to_registration_text),
                )

            }
            Spacer(Modifier.height(SPACER_DONT_HAVE_ACCOUNT_TEXT))
            ActionLinkText(
                text = stringResource(R.string.forgot_password),
            )
        }
        Spacer(Modifier.height(SPACER_DONT_HAVE_ACCOUNT_TEXT_TO_SOCIAL_MEDIA_LINE))
        SocialMediaButtons()
    }

}