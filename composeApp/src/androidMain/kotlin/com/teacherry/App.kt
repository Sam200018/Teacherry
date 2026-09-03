package com.teacherry

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teacherry.home.groups.HomeScreen
import com.teacherry.groups.newgroup.NewGroupScreen

@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen(
                    onNewGroupClick = { navController.navigate("newGroup") }
                )
            }
            composable("newGroup") {
                NewGroupScreen(
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}