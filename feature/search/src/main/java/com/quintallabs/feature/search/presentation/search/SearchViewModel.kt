package com.quintallabs.feature.search.presentation.search

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quintallabs.domain.models.commons.Result
import com.quintallabs.domain.usecases.SearchDrinkUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
  private val searchDrinkUseCase: SearchDrinkUseCase
): ViewModel() {

  private val _state = MutableStateFlow(SearchState())
  val state: StateFlow<SearchState> = _state.asStateFlow()

  fun searchDrink(query: String) {
    viewModelScope.launch {
      _state.value.isLoading = true
      searchDrinkUseCase(query).collect { result ->
        when(result) {
          is Result.Error -> {

          }
          is Result.Success -> {
            _state.update { state ->
              state.copy(
                isLoading = false,
                drinks = result.data.toMutableStateList()
              )
            }
          }
        }
      }
    }
  }

}