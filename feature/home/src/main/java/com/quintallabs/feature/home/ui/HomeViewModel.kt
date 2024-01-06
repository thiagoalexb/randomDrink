package com.quintallabs.feature.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quintallabs.domain.models.commons.Result
import com.quintallabs.domain.usecases.GetRandomDrinkUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
  private val getRandomDrinkUseCase: GetRandomDrinkUseCase
): ViewModel() {

  private val _state = MutableStateFlow(HomeState(isLoading = true))
 val state:StateFlow<HomeState> = _state.asStateFlow()

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
      getRandomDrinkUseCase().collect { result ->
          when(result) {
            is Result.Error -> {
              _state.update { state ->
                state.copy(
                  isLoading = false,
                  generalError = result.error
                )
              }
            }
            is Result.Success -> {
              _state.update { state ->
                state.copy(
                  isLoading = false,
                  randomDrink = result.data
                )
              }
            }
          }
      }
    }

  }
}