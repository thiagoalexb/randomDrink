package com.quintallabs.design.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrinkPropertyList(
  sectionTitle: String,
  properties: List<Pair<String, String>>,
) {
  LazyColumn(
    modifier = Modifier
      .fillMaxWidth()
      .height(180.dp)
      .padding(top = 16.dp)
  ) {
    item {
      Text(
        modifier = Modifier
          .padding(bottom = 8.dp),
        text = sectionTitle,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onPrimary
      )
    }
    items(
      items = properties,
      itemContent = {
        Text(
          modifier = Modifier
            .padding(start = 12.dp, bottom = 12.dp),
          text = "${it.first} - ${it.second}",
          style = MaterialTheme.typography.titleSmall,
          color = MaterialTheme.colorScheme.onPrimary
        )
      }
    )
  }
}