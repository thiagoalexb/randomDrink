package com.quintallabs.feature.home.ui

import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.models.commons.GeneralError

sealed class HomeState1 {
  object Loading: HomeState1()
  data class Success(val drink: Drink): HomeState1()
  data class Error(val error: GeneralError): HomeState1()
}
