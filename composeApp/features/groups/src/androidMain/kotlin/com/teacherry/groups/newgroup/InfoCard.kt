package com.teacherry.groups.newgroup

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import ui.theme.Dimensions

/**
 * A composable that displays an information card with an icon and a text message.
 * It is styled with a light background and a border to highlight important informational content.
 *
 * @param modifier The [Modifier] to be applied to the card surface.
 * @param infoText The text message to be displayed inside the card.
 */
@Composable
fun InfoCard(modifier: Modifier = Modifier, infoText: String) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(Dimensions.spacing12),
        color = Color(0xFFE7F8EA),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            Modifier.padding(all = Dimensions.spacing16),
            verticalAlignment = androidx.compose.ui.Alignment.Top
        ) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "Info Icon",
                tint = MaterialTheme.colorScheme.primaryContainer
            )
            Spacer(Modifier.width(Dimensions.spacing12))
            Text(
                text = infoText,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun InfoCardPreview() {
    InfoCard(infoText = "This is an info card. It can be used to display important information to the user.")
}