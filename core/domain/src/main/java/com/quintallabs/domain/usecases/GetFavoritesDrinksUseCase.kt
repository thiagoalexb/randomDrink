package com.quintallabs.domain.usecases

import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.repositories.IDrinkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetFavoritesDrinksUseCase(
  private val drinkRepository: IDrinkRepository,
) {

  suspend operator fun invoke(): MutableList<Drink> =
    drinkRepository.getFavorites() ?: mutableListOf()

}