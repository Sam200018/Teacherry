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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teacherry.sharedresources.R
import ui.theme.primaryContainerLight

@Composable
fun GroupsFilter(modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
        GroupsFilterButton()
        Spacer(modifier = Modifier.weight(1f))
        NewGroupButton()
    }
}

@Composable
private fun GroupsFilterButton(modifier: Modifier = Modifier) {
    Row(Modifier.padding(vertical = 16.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Outlined.Info, contentDescription = stringResource(R.string.home_screen_my_groups), tint = primaryContainerLight)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(R.string.home_screen_my_groups), style = MaterialTheme.typography.titleMedium )
    }
}

@Composable
private fun NewGroupButton(){
    Row {
        Icon(Icons.Outlined.AddCircle, contentDescription = stringResource(R.string.home_screen_new_group), tint = primaryContainerLight)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(R.string.home_screen_new_group), style = MaterialTheme.typography.titleMedium, color = primaryContainerLight)
    }
}

@Preview(showBackground = true)
@Composable
private fun GroupsFilterPrev() {
    GroupsFilter()
}