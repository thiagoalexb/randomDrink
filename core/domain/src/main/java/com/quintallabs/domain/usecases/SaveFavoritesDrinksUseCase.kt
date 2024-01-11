package com.quintallabs.domain.usecases

import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.repositories.IDrinkRepository

class SaveFavoritesDrinksUseCase(
  private val drinkRepository: IDrinkRepository
) {

  operator fun invoke(drinks: MutableList<Drink>) {
    drinkRepository.saveFavoritesDrinks(drinks)
  }
}