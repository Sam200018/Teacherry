package com.teacherry.loginregistration.data

import com.teacherry.loginregistration.domain.login.LoginRepository

class LoginRepositoryImpl : LoginRepository {
    /**
     * Executes the login process using credentials.
     * Currently, this provides a mock implementation returning a placeholder string.
     *
     * @return A string representing the login result or mock token.
     */
    override suspend fun loginWithCredentials(): String {
        return "Hi module"
    }
}