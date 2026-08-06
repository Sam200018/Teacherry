package ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    data: String
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data)
            .placeholder(R.drawable.imageholder)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.imageholder),
        contentDescription = "description",
        contentScale = ContentScale.Crop,
        modifier = modifier,
    )
}


@Preview(showBackground = true)
@Composable
private fun ImageTecherryPrev() {
    ImageTecherry(data = "https://cdn.milenio.com/uploads/media/2021/05/15/frases-para-el-dia-del.jpg")
}