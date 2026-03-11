package com.teacherry.loginregistration.presentation.login

import com.teacherry.loginregistration.domain.login.LoginRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the Login screen.
 * Manages the UI state and handles user interactions (intents) according to the MVI pattern.
 *
 * @param loginRepository Repository used to perform authentication operations.
 */
class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUIState>(LoginUIState())
    val uiState = _uiState.asStateFlow()

    /**
     * Processes incoming [LoginIntent]s and updates the state or triggers side effects.
     */
    fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.OnLoginWithCredentials -> loginWithCredentials()
            is LoginIntent.OnEmailChange -> onEmailChange(intent.email)
            is LoginIntent.OnPasswordChange -> onPasswordChange(intent.password)
        }
    }

    /**
     * Updates the email field in the UI state.
     *
     * @param newEmail The updated email string.
     */
    fun onEmailChange(newEmail: String) {
        _uiState.value = _uiState.value.copy(email = newEmail)
    }

    /**
     * Updates the password field in the UI state.
     *
     * @param newPassword The updated password string.
     */
    fun onPasswordChange(newPassword: String) {
        _uiState.value = _uiState.value.copy(password = newPassword)
    }

    /**
     * Initiates the login process using the credentials stored in the current UI state.
     */
    fun loginWithCredentials() {
        viewModelScope.launch {
            loginRepository.loginWithCredentials()
        }
    }
}
