package ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * A custom composable that displays a text field which, when clicked, reveals a dropdown menu.
 *
 * @param modifier The [Modifier] to be applied to the text field.
 * @param value The current text value to be displayed in the text field.
 * @param onValueChange Callback triggered when the text field value changes.
 * @param label The label text to be displayed for the text field.
 * @param placeholder The hint text to be displayed when the text field is empty.
 */
@Composable
fun DropdownTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    label: String = "Dropdown Text Field",
    placeholder: String = "Select an option"
) {
    var expanded by remember { mutableStateOf(false) }
    TextFieldTeacherry(
        modifier = modifier.clickable {
            expanded = !expanded
        },
        value = value,
        onValueChange = onValueChange,
        label = label,
        placeholder = placeholder,
        trailingIcon = {
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Dropdown Icon")
        }
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            text = { Text("Option 1") },
            onClick = { expanded = false }
        )
        DropdownMenuItem(
            text = { Text("Option 2") },
            onClick = { expanded = false }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDropdownTextField() {
    DropdownTextField(
        value = "",
        onValueChange = {},
        label = "Dropdown Text Field",
        placeholder = "Select an option"
    )
}