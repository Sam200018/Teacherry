package com.teacherry.home.groups

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teacherry.sharedresources.R
import ui.theme.outlineLight

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier.padding(horizontal = 24.dp)) {
        item {
            TopBarTitle(name = "Samuel Bautista")
        }
        item {
            GroupsFilter()
        }
        items (4) {
            GroupItem()
        }
        item{
            ListEnd()
        }
    }
}

@Composable
fun ListEnd(modifier: Modifier = Modifier) {
    Box(contentAlignment = androidx.compose.ui.Alignment.Center, modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.home_screen_groups_list_end),
            style = MaterialTheme.typography.titleSmall,
            color = outlineLight,
            modifier = Modifier.padding(top = 16.dp, bottom = 32.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}