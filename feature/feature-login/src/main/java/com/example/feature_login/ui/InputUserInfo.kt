package com.example.feature_login.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.core_domain.model.UserInfoDomainModel
import com.example.core_ui.theme.BackgroundInput
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.ui.ButtonLabelText
import com.example.core_ui.ui.InputLabelText
import com.example.core_viewmodel.userInfo_viewModel.UserInfoViewModel
import com.example.feature_login.R
import com.example.feature_login.constant.LoginViewConstant.ELEMENT_HEIGHT
import com.example.feature_login.constant.LoginViewConstant.SPACER_EMAIL_TO_PASSWORD
import com.example.feature_login.constant.LoginViewConstant.SPACER_INPUT_TO_BUTTON
import com.example.feature_login.constant.LoginViewConstant.SPACER_TEXT_TO_INPUT

@Composable
fun InputSpace(isLoginTrue: () -> Unit, userViewModel: UserInfoViewModel) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isErrorEmail = remember { mutableStateOf(false) }
    InputLabelText(
        text = stringResource(R.string.email_label),
    )
    Spacer(Modifier.height(SPACER_TEXT_TO_INPUT))
    InputEmail(email, isErrorEmail)
    Spacer(Modifier.height(SPACER_EMAIL_TO_PASSWORD))
    InputLabelText(
        text = stringResource(R.string.password_label),
    )
    Spacer(Modifier.height(SPACER_TEXT_TO_INPUT))
    InputPassword(password)
    Spacer(Modifier.height(SPACER_INPUT_TO_BUTTON))
    val isValid = isValidAll(email, password, isErrorEmail)
    Button(
        onClick = {
            if (isValid) {
                userViewModel.saveUserInfo(
                    user = UserInfoDomainModel(
                        email = email.value,
                        password = password.value
                    )
                )
                isLoginTrue.invoke()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(ELEMENT_HEIGHT),
        enabled = isValid,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isValid) {
                BrandGreen
            } else {
                BackgroundInput
            },
            disabledContainerColor = if (isValid) {
                BrandGreen
            } else {
                BackgroundInput
            },
            disabledContentColor = BackgroundInput
        ),
        interactionSource = remember { MutableInteractionSource() }
    ) {
        ButtonLabelText(stringResource(R.string.button_label))
    }
}

fun isValidAll(
    email: MutableState<String>,
    password: MutableState<String>,
    isErrorEmail: MutableState<Boolean>
): Boolean {
    return if (email.value.isNotEmpty() && !isErrorEmail.value && password.value.isNotEmpty()) {
        true
    } else {
        false
    }
}


