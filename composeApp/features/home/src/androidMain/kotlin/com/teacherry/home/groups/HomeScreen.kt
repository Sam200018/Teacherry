package com.teacherry.home.groups

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.teacherry.sharedresources.R
import ui.theme.Dimensions

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier.padding(horizontal = Dimensions.spacing24)) {
        item {
            TopBarTitle(name = "Samuel Bautista")
        }
        item {
            GroupsFilter()
        }
        // TODO: update with the actual list of items
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
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.home_screen_groups_list_end),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.padding(top = Dimensions.spacing16, bottom = Dimensions.spacing32)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}