package com.quintallabs.design.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
  navController: NavController,
  title: String = "",
) {

  TopAppBar(
    title = {
      Text(text = title)
    },
    navigationIcon = {
      IconButton(onClick = { navController.navigateUp() }) {
        Icon(
          imageVector = Icons.Filled.ArrowBack,
          contentDescription = "Back"
        )
      }
    }
  )
}