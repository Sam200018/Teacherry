package com.teacherry.features.`login-registration`.login

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
import androidx.compose.ui.unit.dp
import com.teacherry.loginregistration.presentation.login.LoginViewModel
import com.teacherry.sharedresources.R.*
import org.koin.compose.viewmodel.koinViewModel

@Composable

        /**
         * Login screen
         * TODO: implement login screen and all the state
         * @param modifier
         * @param loginViewModel
         */
fun LoginScreen(modifier: Modifier = Modifier, loginViewModel: LoginViewModel = koinViewModel()) {
    LoginScreenImpl {
        loginViewModel.onLogin()
    }
}

/**
 * Implementation of the login screen UI.
 *
 * This composable is kept parameterized so it can be previewed and tested without the ViewModel.
 *
 * @param onLogin callback invoked when the user taps the login button.
 */
@Composable
fun LoginScreenImpl(onLogin: () -> Unit = {}) {
    Scaffold() {
        Box(Modifier.padding(it)) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(stringResource(string.login_registration_login_title))
                Spacer(Modifier.height(40.dp))
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(stringResource(string.login_registration_login_email_label)) })
                Spacer(Modifier.height(20.dp))
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(stringResource(string.login_registration_login_password_label)) })
                Spacer(Modifier.height(20.dp))
                OutlinedButton(onClick = {
                    onLogin()
                }) {
                    Text(stringResource(string.login_registration_login_button_label))
                }
            }
        }
    }
}


@Preview
@Composable
private fun LoginScreenPrev() {
    LoginScreenImpl()
}