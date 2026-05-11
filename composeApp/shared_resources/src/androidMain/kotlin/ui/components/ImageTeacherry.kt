package ui.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.placeholder
import com.teacherry.sharedresources.R

@Composable
fun ImageTecherry(
    modifier: Modifier = Modifier,
    data: String = "https://cdn.milenio.com/uploads/media/2021/05/15/frases-para-el.jpg",
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data)
            .placeholder(R.drawable.holder)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.holder),
        contentDescription = "description",
        contentScale = ContentScale.Crop,
        modifier = modifier.clip(CircleShape),
    )
}


@Preview(showBackground = true)
@Composable
private fun ImageTecherryPrev() {
    ImageTecherry()
}