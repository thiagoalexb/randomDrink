package com.quintallabs.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import com.quintallabs.domain.models.Drink

@Composable
fun DrinkCard(
  drink: Drink,
) {

  ElevatedCard(
    elevation = CardDefaults.cardElevation(
      defaultElevation = 10.dp
    ),
    modifier = Modifier
      .fillMaxWidth(),
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.primary
    )

  ) {
    Column {
      AsyncImage(
        modifier = Modifier.fillMaxWidth(),
        model = ImageRequest.Builder(LocalContext.current)
          .data(drink.drinkThumb)
          .crossfade(true)
          .build(),
        contentScale = ContentScale.FillWidth,
        contentDescription = drink.drinkName,
        onState = {
          when(it) {
            AsyncImagePainter.State.Empty -> {

            }
            is AsyncImagePainter.State.Error -> {

            }
            is AsyncImagePainter.State.Loading -> {

            }
            is AsyncImagePainter.State.Success -> {
              
            }
          }
        }
      )
      Column(
        modifier = Modifier
          .padding(16.dp)
      ) {

        DrinkTitle(drink.drinkName)

        Spacer(modifier = Modifier)

        DrinkPropertyList("Ingredients:", drink.ingredients)

        Spacer(modifier = Modifier)
      }
    }
  }
}