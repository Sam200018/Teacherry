package com.teacherry.home.groups

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ui.theme.primaryContainerLight

@Composable
fun GroupsFilter(modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth()) {
        GroupsFilterButton()
        Spacer(modifier = Modifier.weight(1f))
        NewGroupButton()
    }
}

@Composable
private fun GroupsFilterButton(modifier: Modifier = Modifier) {
    Row(Modifier.padding(vertical = 16.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Outlined.Info, contentDescription = "Filter", tint = primaryContainerLight)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Mis grupos", style = MaterialTheme.typography.titleMedium )
    }
}

@Composable
private fun NewGroupButton(){
    Row {
        Icon(Icons.Outlined.AddCircle, contentDescription = "Filter", tint = primaryContainerLight)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Nuevo", style = MaterialTheme.typography.titleMedium, color = primaryContainerLight)
    }
}

@Preview(showBackground = true)
@Composable
private fun GroupsFilterPrev() {
    GroupsFilter()
}