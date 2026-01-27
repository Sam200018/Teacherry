package com.teacherry.loginregistration.data

import LoginRepository
import kotlinx.coroutines.delay

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(): String {
        delay(2000)

        return "Hi module"
    }
}