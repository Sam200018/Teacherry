package com.teacherry

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.teacherry.features.`login-registration`.login.LoginScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        LoginScreen()
    }
}