package com.quintallabs.feature.search.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
  navController: NavController,
  viewModel: SearchViewModel = koinViewModel(),
) {

  Scaffold { _ ->

    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
      val state = viewModel.state.collectAsState()

      val searchTextState = remember { mutableStateOf("") }

      OutlinedTextField(
        value = searchTextState.value,
        onValueChange = { searchTextState.value = it },
        label = { Text("Procura por drinks") },
        placeholder = { Text(text = "Ingrediente...") },
        trailingIcon = { Icon(Icons.Filled.Search, contentDescription = "Localized description") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
          imeAction = ImeAction.Search
        ),
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
          focusedBorderColor = MaterialTheme.colorScheme.primary,
          focusedLabelColor = MaterialTheme.colorScheme.primary
        ),
        keyboardActions = KeyboardActions(
          onSearch = {
            viewModel.searchDrink(searchTextState.value)
          }
        )
      )

      Spacer(modifier = Modifier.height(16.dp))

      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
      ) {

        items(
          items = state.value.drinks
        ) {
          ElevatedCard(
            elevation = CardDefaults.cardElevation(
              defaultElevation = 6.dp
            ),
            modifier = Modifier
              .fillMaxWidth(),
            onClick = {
              navController.navigate("drink_detail_screen/${it.id}")
            },
            colors = CardDefaults.cardColors(
              containerColor = MaterialTheme.colorScheme.primary
            )
          ) {
            Text(
              text = it.drinkName,
              style = MaterialTheme.typography.bodyLarge,
              color = MaterialTheme.colorScheme.onPrimary,
              modifier = Modifier
                .padding(16.dp)
            )
          }
          Spacer(modifier = Modifier.height(16.dp))
        }
      }
    }
  }
}