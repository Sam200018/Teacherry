package com.teacherry.home.groups

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.teacherry.sharedresources.R
import ui.theme.Dimensions

@Composable
fun TopBarTitle(name: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = Dimensions.spacing32, bottom = Dimensions.spacing16)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.home_screen_welcome_title),
                color = MaterialTheme.colorScheme.primaryContainer,
                style = typography.titleSmall
            )
            Text(
                text = stringResource(R.string.home_screen_welcome_name, name),
                style = typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
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
    TopBarTitle("Tomas")
}