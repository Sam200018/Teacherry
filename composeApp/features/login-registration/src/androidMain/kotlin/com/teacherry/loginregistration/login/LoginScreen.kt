package com.teacherry.loginregistration.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.teacherry.loginregistration.presentation.login.LoginIntent
import com.teacherry.loginregistration.presentation.login.LoginViewModel
import com.teacherry.sharedresources.R.*
import org.koin.compose.viewmodel.koinViewModel
import ui.theme.Dimensions

@Composable

        /**
         * Login screen
         * TODO: implement login screen and all the state
         * @param modifier
         * @param loginViewModel
         */
fun LoginScreen(modifier: Modifier = Modifier, loginViewModel: LoginViewModel = koinViewModel()) {
    LoginScreenImpl(
        onEvent = { event ->
            when (event) {
                is LoginIntent.OnEmailChange -> loginViewModel.onEmailChange(event.email)
                is LoginIntent.OnPasswordChange -> loginViewModel.onPasswordChange(event.password)
                is LoginIntent.OnLoginWithCredentials -> loginViewModel.loginWithCredentials()
            }
        },
    )
}

/**
 * Implementation of the login screen UI.
 *
 * This composable is kept parameterized so it can be previewed and tested without the ViewModel.
 *
 * @param onLoginWithCredentials callback invoked when the user taps the login button.
 */
@Composable
fun LoginScreenImpl(
    onEvent: (LoginIntent) -> Unit,

) {
    Scaffold {
        Box(Modifier.padding(it)) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(stringResource(string.login_registration_login_title))
                Spacer(Modifier.height(Dimensions.spacing40))
                TextField(
                    value = "",
                    onValueChange = { email ->
                        onEvent(LoginIntent.OnEmailChange(email))
                    },
                    label = { Text(stringResource(string.login_registration_login_email_label)) })
                Spacer(Modifier.height(Dimensions.spacing20))
                TextField(
                    value = "",
                    onValueChange = { password ->
                        onEvent(LoginIntent.OnPasswordChange(password))
                    },
                    label = { Text(stringResource(string.login_registration_login_password_label)) })
                Spacer(Modifier.height(Dimensions.spacing20))
                OutlinedButton(onClick = {
                        onEvent(LoginIntent.OnLoginWithCredentials)
                }) {
                    Text(stringResource(string.login_registration_login_button_label))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPrev() {
    LoginScreenImpl() {}
}