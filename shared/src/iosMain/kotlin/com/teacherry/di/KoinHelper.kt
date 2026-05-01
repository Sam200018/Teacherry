package com.teacherry.di

import com.teacherry.loginregistration.presentation.login.LoginViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class KoinHelper : KoinComponent {
    fun getLoginViewModel(): LoginViewModel = get()
}