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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ui.components.ImageTecherry
import ui.theme.onSurfaceVariantLight
import ui.theme.primaryContainerLight
import ui.theme.secondaryLight

@Composable
fun GroupItem(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White, // Background color
        ), shape = RoundedCornerShape(20.dp), modifier = modifier.padding(vertical = 8.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)) {
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .fillMaxHeight()
                    .background(
                        color = primaryContainerLight,
                        shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)
                    )
            )
            Column(modifier = Modifier
                .weight(1f)
                .padding(16.dp)) {
                ImageTecherry(modifier = Modifier.fillMaxWidth().height(96.dp))
                Spacer(modifier = Modifier.height(8.dp))
                GroupInfo()
            }
        }
    }
}

@Composable
private fun GroupInfo() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column() {
            Text(text = "Group name", style = MaterialTheme.typography.titleLarge)
            Text(
                text = "Group description",
                style = MaterialTheme.typography.bodyLarge,
                color = onSurfaceVariantLight
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "ACTIVO",
            color = primaryContainerLight,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .background(Color(0xFFE7F8EA), RoundedCornerShape(50))
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

    }
    Spacer(modifier = Modifier.height(16.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.Person, contentDescription = "Members", tint = primaryContainerLight)
        Text(text = "Members: 10")
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = primaryContainerLight)
        ) {
            Text(text = "Entrar", color = secondaryLight)
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Enter group",
                tint = secondaryLight
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GroupItemPrev() {
    GroupItem()
}