package com.teacherry.loginregistration.presentation.login

data class LoginUIState(
    val email : String = "",
    val password : String = "",
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val isError: Boolean = false,
    val message: String? = null
)