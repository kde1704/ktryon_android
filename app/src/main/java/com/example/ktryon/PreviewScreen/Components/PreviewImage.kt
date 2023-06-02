package com.example.ktryon.PreviewScreen.Components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ktryon.R

@Composable
fun PreviewImage(url: String, modifier: Modifier = Modifier) {
    val async_painter = rememberAsyncImagePainter(
        model =
        ImageRequest.Builder(LocalContext.current)
            .data(url)
            .size(coil.size.Size.ORIGINAL)
            .crossfade(true)
            .build()
    )

    val painter = if (async_painter.state is AsyncImagePainter.State.Success) {
        async_painter
    } else {
        painterResource(id = R.drawable.placeholder)
    }

    Image(
        modifier = modifier,
        contentScale = ContentScale.FillWidth,
        painter = painter,
        contentDescription = null
    )
}