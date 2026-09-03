package com.teacherry.groups.newgroup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.teacherry.sharedresources.R
import ui.components.DropdownTextField
import ui.components.TextFieldTeacherry
import ui.theme.Dimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewGroupScreen(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        stringResource(R.string.new_screen_header_title),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        containerColor = Color.White
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = Dimensions.spacing60, y = (-Dimensions.spacing60))
                    .size(Dimensions.spacing200)
                    .clip(CircleShape)
                    .background(Color(0xFFEAF9EF))
            )

            NewGroupScreenImpl(modifier = Modifier.padding(paddingValues))
        }
    }
}

@Composable
fun NewGroupScreenImpl(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = Dimensions.spacing24),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(Dimensions.spacing16))


        Box(
            modifier = Modifier
                .size(Dimensions.spacing72)
                .clip(CircleShape)
                .background(Color(0xFFE7F8EA)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.size(Dimensions.spacing32)
            )
        }

        Spacer(Modifier.height(Dimensions.spacing16))

        Text(
            text = stringResource(R.string.new_screen_header_subtitle),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(Modifier.height(Dimensions.spacing8))

        Text(
            text = stringResource(R.string.new_screen_description),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )

        Spacer(Modifier.height(Dimensions.spacing32))

        TextFieldTeacherry(
            value = "",
            onValueChange = {},
            label = stringResource(R.string.new_screen_group_name_label),
            placeholder = stringResource(R.string.new_screen_group_name_placeholder),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(Dimensions.spacing24))

        DropdownTextField(
            value = "",
            onValueChange = {},
            label = stringResource(R.string.new_screen_group_level_label),
            placeholder = stringResource(R.string.new_screen_group_level_placeholder),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(Dimensions.spacing24))

        InfoCard(
            infoText = stringResource(R.string.new_screen_group_info_text),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.weight(1f))

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Dimensions.spacing32)
                .height(Dimensions.spacing56),
            shape = RoundedCornerShape(Dimensions.spacing12),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = Color.Black
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.new_screen_group_create_cta_label),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.width(Dimensions.spacing8))
                Icon(
                    imageVector = Icons.Outlined.AddCircle,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NewGroupScreenPreview() {
    NewGroupScreen()
}
