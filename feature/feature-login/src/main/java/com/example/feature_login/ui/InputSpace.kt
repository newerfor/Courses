package com.example.feature_login.ui

import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.core_ui.theme.BackgroundInput
import com.example.core_ui.theme.InputErrorColor
import com.example.core_ui.theme.Roboto
import com.example.core_ui.theme.TextPrimary
import com.example.core_ui.ui.ErrorInputText
import com.example.core_ui.ui.InputPlaceholderText
import com.example.feature_login.R
import com.example.feature_login.constant.LoginViewConstant.ELEMENT_HEIGHT
import com.example.feature_login.constant.LoginViewConstant.INPUT_BORDER
import com.example.feature_login.constant.LoginViewConstant.INPUT_PADDING
import com.example.feature_login.constant.LoginViewConstant.INPUT_SHAPE
import com.example.feature_login.constant.LoginViewConstant.SPACER_INPUT_TO_ERROR_TEXT
import com.example.feature_login.constant.LoginViewConstant.TEXT_INPUT_FONT_SIZE

@Composable
fun InputEmail(email: MutableState<String>, isErrorEmail: MutableState<Boolean>) {
    var isTouched by remember { mutableStateOf(false) }
    Column {
        BasicTextField(
            value = email.value,
            onValueChange = { newEmail ->
                val filtered = newEmail.filter { char: Char ->
                    char !in 'а'..'я' && char !in 'А'..'Я' && char != 'ё' && char != 'Ё'
                }
                email.value = filtered
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(ELEMENT_HEIGHT)
                .onFocusChanged { focusState ->
                    if (!focusState.isFocused && isTouched) {
                        isErrorEmail.value = if (email.value.isNotEmpty()) {
                            !isValidEmail(email.value)
                        } else true
                    }
                    if (focusState.isFocused) isTouched = true
                },
            textStyle = TextStyle(
                fontFamily = Roboto,
                fontWeight = FontWeight.Normal,
                fontSize = TEXT_INPUT_FONT_SIZE,
                color = TextPrimary
            ),
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = BackgroundInput,
                            shape = RoundedCornerShape(INPUT_SHAPE)
                        )
                        .then(
                            if (isErrorEmail.value) {
                                Modifier.border(
                                    width = INPUT_BORDER,
                                    color = InputErrorColor,
                                    shape = RoundedCornerShape(INPUT_SHAPE)
                                )
                            } else Modifier
                        )
                        .padding(horizontal = INPUT_PADDING),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (email.value.isEmpty()) {
                        InputPlaceholderText(
                            text = stringResource(R.string.email_placeholder),
                        )
                    }
                    innerTextField()
                }
            }
        )
        if (isErrorEmail.value && isTouched) {
            Spacer(Modifier.height(SPACER_INPUT_TO_ERROR_TEXT))
            ErrorInputText(stringResource(R.string.email_error_text))
        }
    }
}

@Composable
fun InputPassword(password: MutableState<String>) {
    BasicTextField(
        value = password.value,
        onValueChange = { newPassword ->
            password.value = newPassword
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(ELEMENT_HEIGHT),
        textStyle = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = TEXT_INPUT_FONT_SIZE,
            color = TextPrimary
        ),
        singleLine = true,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = BackgroundInput,
                        shape = RoundedCornerShape(INPUT_SHAPE)
                    )
                    .padding(horizontal = INPUT_PADDING),
                contentAlignment = Alignment.CenterStart
            ) {
                if (password.value.isEmpty()) {
                    InputPlaceholderText(
                        text = stringResource(R.string.password_placeholder),
                    )
                }
                innerTextField()
            }
        }
    )
}
fun isValidEmail(value: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(value).matches()
}
