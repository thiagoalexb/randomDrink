package com.quintallabs.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.models.commons.Result
import com.quintallabs.domain.usecases.GetFavoritesDrinksUseCase
import com.quintallabs.domain.usecases.GetRandomDrinkUseCase
import com.quintallabs.domain.usecases.SaveFavoritesDrinksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
  private val getRandomDrinkUseCase: GetRandomDrinkUseCase,
  private val getFavoritesDrinksUseCase: GetFavoritesDrinksUseCase,
  private val saveFavoritesDrinksUseCase: SaveFavoritesDrinksUseCase,
) : ViewModel() {

  private val _state = MutableStateFlow(HomeState(isLoading = true))
  val state: StateFlow<HomeState> = _state.asStateFlow()

  init {
    getNewRandomDrink()
  }

  fun getNewRandomDrink() {
    viewModelScope.launch {
      _state.update { state ->
        state.copy(
          isLoading = true
        )
      }

      getRandomDrinkUseCase().collect { resultRandomDrink ->
        when (resultRandomDrink) {
          is Result.Error -> {
            _state.update { state ->
              state.copy(
                isLoading = false,
                generalError = resultRandomDrink.error
              )
            }
          }

          is Result.Success -> {
            val favoritesDrinks = getFavoritesDrinksUseCase()
            _state.update { state ->
              state.copy(
                isLoading = false,
                randomDrink = resultRandomDrink.data,
                isFavorite = favoritesDrinks.any { it.id == resultRandomDrink.data.id },
                favorites = favoritesDrinks
              )
            }
          }
        }
      }

    }
  }

  fun saveFavoriteDrink(drink: Drink) {
    viewModelScope.launch {
      val homeState = _state.value

      if (!checkIfIsFavorite(drink, homeState.favorites)) {
        drink.isFavorite = true
        homeState.favorites.add(drink)
      } else {
        homeState.favorites.removeIf { it.id == drink.id }
      }

      saveFavoritesDrinksUseCase(homeState.favorites)

    }
  }

  private fun checkIfIsFavorite(drink: Drink, favorites: MutableList<Drink>): Boolean {
    return favorites.any { it.id == drink.id }
  }
}