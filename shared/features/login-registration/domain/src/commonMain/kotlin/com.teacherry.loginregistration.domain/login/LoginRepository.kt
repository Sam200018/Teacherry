package com.teacherry.loginregistration.domain.login


interface LoginRepository {
    /**
     * Authenticates the user using their credentials.
     *
     * @return A string representing the authentication result or token.
     */
    suspend fun loginWithCredentials(): String
}