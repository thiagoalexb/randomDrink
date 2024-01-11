package com.quintallabs.feature.favorites.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quintallabs.design.components.DrinkCard
import com.quintallabs.design.components.LoadingDialog
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteScreen(
  viewModel: FavoritesViewModel = koinViewModel(),
) {
  Scaffold { _ ->
    val state by viewModel.state.collectAsState()

    LoadingDialog(state.isLoading)

    if (!state.isLoading && state.favorites.isEmpty()) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .background(MaterialTheme.colorScheme.background)
          .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = "Nenhum favorito adicionado",
          style = MaterialTheme.typography.headlineMedium,
          color = MaterialTheme.colorScheme.onBackground
        )
      }
    } else if(!state.isLoading) {
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .background(MaterialTheme.colorScheme.background)
          .padding(top = 16.dp, start = 16.dp, end = 16.dp)
      ) {
        items(
          items = state.favorites,
        ) {
          DrinkCard(
            it,
            viewModel::saveFavoriteDrink
          )
          Spacer(modifier = Modifier.size(16.dp))
        }
      }
    }
  }
}