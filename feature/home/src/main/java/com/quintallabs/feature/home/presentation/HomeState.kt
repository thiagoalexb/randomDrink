package com.quintallabs.feature.home.presentation

import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.models.commons.GeneralError

data class HomeState(
  val isLoading: Boolean = false,
  val randomDrink: Drink? = null,
  val isFavorite: Boolean = false,
  val generalError: GeneralError? = null,
  val favorites: MutableList<Drink> = mutableListOf()
)