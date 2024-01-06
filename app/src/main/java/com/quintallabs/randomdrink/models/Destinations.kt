package com.quintallabs.randomdrink.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
  val route: String,
  val title: String? = null,
  val icon: ImageVector? = null
) {
  object HomeScreen : Destinations(
    route = "home_screen",
    title = "Home",
    icon = Icons.Outlined.Home
  )

  object Favourite : Destinations(
    route = "search_screen",
    title = "Search",
    icon = Icons.Outlined.Favorite
  )
}
