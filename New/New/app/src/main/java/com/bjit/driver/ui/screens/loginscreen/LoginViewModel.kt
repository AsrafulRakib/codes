package com.bjit.driver.ui.screens.loginscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import com.bjit.driver.data.remote.models.login.LoginModel
import com.bjit.driver.repository.DriverRepository
import com.bjit.driver.repository.SettingsRepository
import com.bjit.driver.util.Resource
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: DriverRepository,
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    var isLoggedIn = mutableStateOf(false)
    var isLoading = mutableStateOf(false)
    var loginError = mutableStateOf("")


    init {
        isLoggedIn.value = settingsRepository.getIsLoggedIn()
    }

    fun loginRequest(body: LoginModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.postLogin(body)
            response
                .catch {
                    Timber.e("Error $this")
                }
                .collect { resource ->
                    when (resource) {
                        is Resource.Loading -> {
                            isLoading.value = true
                        }
                        is Resource.Success -> {
                            isLoading.value = false
                            isLoggedIn.value = true
                            settingsRepository.setIsLoggedIn(true)
                            resource.data?.token?.let { settingsRepository.setAuthToken(token = it) }
                        }
                        is Resource.Error -> {
                            isLoading.value = false
                            isLoggedIn.value = false
                            settingsRepository.setIsLoggedIn(false)
                            loginError.value = resource.errorMessage!!
                        }
                    }
                }
        }
    }

    fun logout() {
        settingsRepository.setIsLoggedIn(false)
        isLoggedIn.value = false
    }
}