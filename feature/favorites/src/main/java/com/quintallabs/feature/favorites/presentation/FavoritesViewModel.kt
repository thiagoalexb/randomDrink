package com.quintallabs.feature.favorites.presentation

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.usecases.GetFavoritesDrinksUseCase
import com.quintallabs.domain.usecases.SaveFavoritesDrinksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesViewModel(
  private val getFavoritesDrinksUseCase: GetFavoritesDrinksUseCase,
  private val saveFavoritesDrinksUseCase: SaveFavoritesDrinksUseCase,
) : ViewModel() {

  private val _state = MutableStateFlow(FavoritesState(isLoading = true))
  val state: StateFlow<FavoritesState> = _state.asStateFlow()

  init {
    getFavorites()
  }

  private fun getFavorites() {
    viewModelScope.launch {
      _state.value.isLoading = true
      val favoritesDrinks = getFavoritesDrinksUseCase()
      _state.value.isLoading = false
      _state.value.favorites = favoritesDrinks.toMutableStateList()
    }
  }

  fun saveFavoriteDrink(drink: Drink, isFavorite: Boolean = false) {

    val favoriteState = _state.value
    val favorites = favoriteState.favorites

    favorites.removeIf { it.id == drink.id }

    saveFavoritesDrinksUseCase(favorites)

    _state.update {
      it.copy(
        isLoading = false,
        favorites = favorites
      )
    }
  }
}