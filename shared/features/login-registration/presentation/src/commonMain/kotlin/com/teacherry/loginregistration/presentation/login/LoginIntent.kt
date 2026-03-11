package com.teacherry.loginregistration.presentation.login

/**
 * Represents the various user actions (intents) that can be performed on the Login screen.
 * This sealed class is used to communicate events from the UI to the [LoginViewModel].
 */
sealed class LoginIntent {
    /**
     * Triggered when the user taps the login button to authenticate with their credentials.
     */
    object OnLoginWithCredentials : LoginIntent()

    /**
     * Triggered when the user changes the text in the email input field.
     * @param email The new email string entered by the user.
     */
    data class OnEmailChange(val email: String) : LoginIntent()

    /**
     * Triggered when the user changes the text in the password input field.
     * @param password The new password string entered by the user.
     */
    data class OnPasswordChange(val password: String) : LoginIntent()
}
