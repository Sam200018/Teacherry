package com.teacherry.home.groups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.teacherry.sharedresources.R
import ui.components.ImageTecherry
import ui.theme.Dimensions

/**
 * Displays a group card with a cover image, basic group information, status, and an enter action.
 *
 * @param modifier Modifier applied to the card container.
 * @param groupName Name displayed for the group.
 * @param groupDescription Short description displayed below the group name.
 */
@Composable
fun GroupItem(
    modifier: Modifier = Modifier,
    groupName: String = "Group name",
    groupDescription: String = "Group description"
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ), shape = RoundedCornerShape(Dimensions.spacing20), modifier = modifier.padding(vertical = Dimensions.spacing8)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min))
        {
            Box(
                modifier = Modifier
                    .width(Dimensions.spacing8)
                    .fillMaxHeight()
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(topStart = Dimensions.spacing20, bottomStart = Dimensions.spacing20)
                    )
            )
            Column(modifier = Modifier
                .weight(1f)
                .padding(Dimensions.spacing16)) {
                ImageTecherry(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Dimensions.spacing96),
                    data = "https://cdn.milenio.com/uploads/media/2021/05/15/frases-para-el-dia-del.jpg"
                )
                Spacer(modifier = Modifier.height(Dimensions.spacing8))
                GroupInfo(groupName = groupName, groupDescription = groupDescription)
                Spacer(modifier = Modifier.height(Dimensions.spacing16))
                GroupMembersEnterCTA()
            }
        }
    }
}

/**
 * Shows the textual details and actions for a group, including its status, member count,
 * and a button to enter the group.
 *
 * @param groupName Name displayed for the group.
 * @param groupDescription Short description displayed below the group name.
 */

@Composable
private fun GroupInfo(
    modifier: Modifier = Modifier,
    groupName: String = "Group name",
    groupDescription: String = "Group description"
) {
    Row(modifier,verticalAlignment = Alignment.CenterVertically) {
        Column {
            Text(text = groupName, style = MaterialTheme.typography.titleLarge)
            Text(
                text = groupDescription,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(R.string.home_screen_group_active_status),
            color = MaterialTheme.colorScheme.primaryContainer,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .background(Color(0xFFE7F8EA), RoundedCornerShape(50))
                .padding(horizontal = Dimensions.spacing16, vertical = Dimensions.spacing8)
        )

    }
}


@Composable
fun GroupMembersEnterCTA(modifier: Modifier = Modifier) {
    Row(modifier,
        verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.Person, contentDescription = "Members", tint = MaterialTheme.colorScheme.primaryContainer)
        Text(text = stringResource(R.string.home_screen_group_members, "10"))
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                //TODO: Implement enter group action
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(
                text = stringResource(R.string.home_screen_group_enter_label),
                color = MaterialTheme.colorScheme.secondary
            )
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Enter group",
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GroupItemPrev() {
    GroupItem()
}