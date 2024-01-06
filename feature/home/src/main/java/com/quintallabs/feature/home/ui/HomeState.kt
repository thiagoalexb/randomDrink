package com.quintallabs.feature.home.ui

import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.models.commons.GeneralError
import com.quintallabs.domain.models.commons.Result

data class HomeState(
  val isLoading: Boolean = false,
  val randomDrink: Drink? = null,
  val generalError: GeneralError? = null
)