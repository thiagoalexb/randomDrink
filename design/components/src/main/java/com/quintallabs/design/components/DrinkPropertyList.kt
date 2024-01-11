package com.quintallabs.design.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
  Column {
    Text(
      modifier = Modifier
        .padding(bottom = 12.dp),
      text = sectionTitle,
      style = MaterialTheme.typography.titleLarge,
      color = MaterialTheme.colorScheme.onPrimary
    )

    for(property in properties) {

      var text = property.first
      text += if(property.second.isNotBlank())
        " - ${property.second}"
      else
        ""

      Text(
        modifier = Modifier
          .padding(start = 12.dp, bottom = 12.dp),
        text = text,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onPrimary
      )
    }
  }
}