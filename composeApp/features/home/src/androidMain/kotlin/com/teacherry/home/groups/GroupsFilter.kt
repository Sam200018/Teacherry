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

/**
 * Top-level row that shows the groups filter UI for the home screen.
 *
 * This composable lays out a filter entry ("My groups") on the left and a
 * "New group" action on the right. It accepts a [modifier] so callers can
 * customize sizing, padding or click handling.
 *
 * @param modifier Modifier to be applied to the root [Row]. Defaults to [Modifier].
 */
@Composable
fun GroupsFilter(modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        GroupsFilterButton()
        Spacer(modifier = Modifier.weight(1f))
        NewGroupButton()
    }
}

/**
 * Renders the "My groups" filter entry with an info icon.
 *
 * This is a private helper used by [GroupsFilter]. It shows an info icon and
 * the localized "My groups" label. A [modifier] can be provided to adjust
 * layout properties like padding.
 *
 * @param modifier Modifier to be applied to the inner [Row]. Defaults to [Modifier].
 */
@Composable
private fun GroupsFilterButton(modifier: Modifier = Modifier) {
    Row(modifier.padding(vertical = 16.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            Icons.Outlined.Info,
            contentDescription = stringResource(R.string.home_screen_my_groups),
            tint = MaterialTheme.colorScheme.primaryContainer
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(R.string.home_screen_my_groups),
            style = MaterialTheme.typography.titleMedium
        )
    }
}

/**
 * Renders the "New group" action entry with an add icon.
 *
 * This is a private helper used by [GroupsFilter]. It displays an add icon
 * followed by the localized "New group" label.
 */
@Composable
private fun NewGroupButton() {
    Row {
        Icon(
            Icons.Outlined.AddCircle,
            contentDescription = stringResource(R.string.home_screen_new_group),
            tint = MaterialTheme.colorScheme.primaryContainer
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(R.string.home_screen_new_group),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primaryContainer
        )
    }
}

/**
 * Preview for [GroupsFilter] used by Android Studio/Tooling.
 */
@Preview(showBackground = true)
@Composable
private fun GroupsFilterPrev() {
    GroupsFilter()
}