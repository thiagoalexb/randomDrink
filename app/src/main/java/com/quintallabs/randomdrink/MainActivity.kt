@file:OptIn(ExperimentalMaterialApi::class)

package com.quintallabs.randomdrink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quintallabs.feature.home.ui.HomeScreen
import com.quintallabs.randomdrink.models.Destinations
import com.quintallabs.randomdrink.theme.RandomDrinkTheme
import com.quintallabs.randomdrink.ui.BottomBar
import com.quintallabs.search.ui.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      RandomDrinkTheme(
        dynamicColor = false
      ) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          val navController: NavHostController = rememberNavController()

          Scaffold(
            bottomBar = {
              BottomBar(
                navController = navController,
                modifier = Modifier
              )
            }) { paddingValues ->
            Box(
              modifier = Modifier.padding(paddingValues)
            ) {
              NavigationGraph(navController = navController)
            }
          }
        }
      }
    }
  }
}


@Composable
fun NavigationGraph(navController: NavHostController) {
  NavHost(navController, startDestination = Destinations.HomeScreen.route) {
    composable(Destinations.HomeScreen.route) {
      HomeScreen()
    }
    composable(Destinations.Favourite.route) {
      SearchScreen()
    }
  }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  RandomDrinkTheme {

  }
}