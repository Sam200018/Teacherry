package com.teacherry.home.groups

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ui.theme.primaryContainerLight
import ui.theme.primaryTextLight

@Composable
fun TopBarTitle(modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth().padding(top = 32.dp, bottom = 16.dp)) {
        Column() {
            Text(
                text = "Bienvenida",
                color = primaryContainerLight,
                style = typography.titleSmall
            )
            Text(
                text = "¡Hola, Samuel Bautista!",
                style = typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = primaryTextLight
            )
        }
        Icon(
            imageVector = Icons.Outlined.Notifications, contentDescription = "Notifications"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopBarTitlePrev() {
    TopBarTitle(modifier = Modifier)
}