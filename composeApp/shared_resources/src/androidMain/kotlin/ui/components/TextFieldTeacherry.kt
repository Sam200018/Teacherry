package ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ui.theme.Dimensions

/**
 * A custom styled text field component for the Teacherry application that wraps an [OutlinedTextField]
 * with a top-level label and predefined styling.
 *
 * @param modifier The [Modifier] to be applied to the component's container.
 * @param value The current value of the text field.
 * @param onValueChange Callback triggered when the text field value changes.
 * @param label The label text to be displayed above the text field.
 * @param placeholder The hint text to be displayed when the text field is empty.
 * @param leadingIcon Optional icon to be displayed at the beginning of the text field.
 * @param trailingIcon Optional icon to be displayed at the end of the text field.
 * @param isError Whether the text field has an error state.
 * @param errorLabel The error text to be displayed when [isError] is true.
 * @param keyboardOptions Optional [KeyboardOptions] to be applied to the text field.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldTeacherry(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorLabel: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    Column() {
        Text(
            text = label,
            modifier = Modifier.padding(bottom = Dimensions.spacing8)
        )
        OutlinedTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            placeholder = { Text(placeholder) },
            leadingIcon = leadingIcon,
            isError = isError,
            supportingText = { Text(errorLabel) },
            keyboardOptions = keyboardOptions,
            shape = RoundedCornerShape(Dimensions.spacing12),
            trailingIcon = trailingIcon,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldTeacherryPreview() {
    TextFieldTeacherry(
        value = "",
        onValueChange = {},
        label = "Text Field",
        placeholder = "Enter text",
    )
}
