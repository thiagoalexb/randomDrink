package com.quintallabs.feature.search.presentation.detail

import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.models.commons.GeneralError

data class DrinkDetailState(
  val isLoading: Boolean = false,
  val drink: Drink? = null,
  val generalError: GeneralError? = null,
  val favorites: MutableList<Drink> = mutableListOf(),
  val isFavorite: Boolean = false
)