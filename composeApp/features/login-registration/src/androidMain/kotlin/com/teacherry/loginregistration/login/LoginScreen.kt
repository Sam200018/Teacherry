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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teacherry.loginregistration.presentation.login.LoginViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(modifier: Modifier = Modifier, loginViewModel: LoginViewModel = koinViewModel()) {
    Scaffold() {
        Box(modifier.padding(it)) {
            Column(
                modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Login Screen")
                Spacer(Modifier.height(40.dp))
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Email") }
                )
                Spacer(Modifier.height(20.dp))
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Password") }
                )
                Spacer(Modifier.height(20.dp))
                OutlinedButton(onClick = {
                    loginViewModel.onLogin()
                }) {
                    Text("Login")
                }
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPrev() {
    LoginScreen()
}