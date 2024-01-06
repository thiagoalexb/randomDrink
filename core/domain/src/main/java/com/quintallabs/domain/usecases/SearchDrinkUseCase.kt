package com.quintallabs.domain.usecases

import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.models.commons.GeneralError
import com.quintallabs.domain.models.commons.Result
import com.quintallabs.domain.repositories.IDrinkRepository
import kotlinx.coroutines.flow.Flow

class SearchDrinkUseCase (
  private val drinkRepository: IDrinkRepository,
) {

  suspend operator fun invoke(query: String): Flow<Result<List<Drink>, GeneralError>> =
    drinkRepository.searchDrink(query)

}