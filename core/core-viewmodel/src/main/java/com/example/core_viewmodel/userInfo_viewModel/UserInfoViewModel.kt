package com.example.core_viewmodel.userInfo_viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_domain.model.UserInfoDomainModel
import com.example.core_domain.useCase.GetUserInfoUseCase
import com.example.core_domain.useCase.SaveUserInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserInfoViewModel(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val saveUserInfoUseCase: SaveUserInfoUseCase
) : ViewModel() {
    private val _userUiState = MutableStateFlow<UserInfoUIState>(UserInfoUIState.Loading)
    val userUiState: StateFlow<UserInfoUIState> = _userUiState.asStateFlow()

    init {
        getUserInfo()
    }

    fun getUserInfo() {
        viewModelScope.launch {

            _userUiState.value = UserInfoUIState.Loading
            val result = getUserInfoUseCase.invoke()
            result.onSuccess { user ->
                if (user == null) {
                    _userUiState.value = UserInfoUIState.Empty
                } else {
                    _userUiState.value = UserInfoUIState.Success(user)
                }
            }.onFailure { error ->
                _userUiState.value = UserInfoUIState.Error(error.toString())
            }
        }
    }

    fun saveUserInfo(user: UserInfoDomainModel) {
        viewModelScope.launch {
            saveUserInfoUseCase.invoke(user)
        }
    }
}