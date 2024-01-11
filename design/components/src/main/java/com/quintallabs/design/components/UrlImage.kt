package com.quintallabs.design.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun UrlImage(drinkThumb: String?, drinkContentDescription: String?) {
  AsyncImage(
    modifier = Modifier.fillMaxWidth(),
    model = ImageRequest.Builder(LocalContext.current)
      .data(drinkThumb)
      .crossfade(true)
      .build(),
    contentScale = ContentScale.FillWidth,
    contentDescription = drinkContentDescription
  )
}