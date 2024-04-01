package com.example.analayzermobile.design

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow<String>("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow<String>("")
    val password: StateFlow<String> = _password

    private val _loginEnable = MutableStateFlow<Boolean>(false)
    val loginEnable: StateFlow<Boolean> = _loginEnable

    private val _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 5

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    suspend fun onLoginSelected() {
        _isLoading.value = true
        delay(2000)
        _isLoading.value = false
    }
}

