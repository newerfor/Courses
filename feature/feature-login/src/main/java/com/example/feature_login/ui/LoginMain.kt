package com.example.feature_login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.core_ui.theme.Background
import com.example.core_viewmodel.userInfo_viewModel.UserInfoUIState
import com.example.core_viewmodel.userInfo_viewModel.UserInfoViewModel
import com.example.feature_login.constant.LoginViewConstant.LOGIN_SCREEN_PADDING_TOP
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginMainScreen(isLoginTrue: () -> Unit) {
    Column(Modifier
        .fillMaxSize()
        .background(Background)
        .verticalScroll(rememberScrollState())) {
        LoginMain(isLoginTrue = isLoginTrue)
    }
}

@Composable
fun LoginMain(
    userViewModel: UserInfoViewModel = koinViewModel(),
    isLoginTrue: () -> Unit,
) {
    val userUiState by userViewModel.userUiState.collectAsState()
    val isLogging = remember { mutableStateOf(false) }
    LaunchedEffect(userUiState) {
        if (userUiState is UserInfoUIState.Success) {
            isLogging.value = true
        }
    }
    Column(Modifier
        .fillMaxSize()
        .systemBarsPadding()
        .padding(top = LOGIN_SCREEN_PADDING_TOP)) {
        if (!isLogging.value) {
            LoginScreen(isLoginTrue, userViewModel)
        } else {
            isLoginTrue.invoke()
        }
    }
}

