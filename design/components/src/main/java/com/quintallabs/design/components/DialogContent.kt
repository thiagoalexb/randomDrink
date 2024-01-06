package com.quintallabs.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DialogContent() {
  Box {
    CircularProgressIndicator(
      modifier = Modifier
        .align(
          Alignment.Center
        ),
      color = Color.Red
    )
  }
}