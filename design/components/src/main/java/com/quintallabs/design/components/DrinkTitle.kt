package com.quintallabs.design.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DrinkTitle(title: String) {
  Text(
    modifier = Modifier.fillMaxWidth(),
    text = title,
    style = MaterialTheme.typography.headlineMedium,
    color = MaterialTheme.colorScheme.onPrimary
  )
}