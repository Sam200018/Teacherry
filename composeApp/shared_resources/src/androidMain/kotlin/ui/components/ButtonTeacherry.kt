package ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import ui.theme.Dimensions

/**
 * A custom styled button component for the Teacherry application.
 *
 * @param modifier The [Modifier] to be applied to the button layout.
 * @param buttonText The text label to be displayed inside the button.
 */
@Composable
fun ButtonTeacherry(modifier: Modifier = Modifier, buttonText: String) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.spacing56),
        shape = RoundedCornerShape(Dimensions.spacing12),
        onClick = {}) {
        Text(text = buttonText, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
private fun ButtonTeacherryPrev() {
    ButtonTeacherry(buttonText = "Hola")
}