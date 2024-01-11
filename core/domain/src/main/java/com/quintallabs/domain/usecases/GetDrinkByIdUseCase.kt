package com.quintallabs.domain.usecases

import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.models.commons.GeneralError
import com.quintallabs.domain.models.commons.Result
import com.quintallabs.domain.repositories.IDrinkRepository
import kotlinx.coroutines.flow.Flow

class GetDrinkByIdUseCase(
  private val drinkRepository: IDrinkRepository
) {

  operator fun invoke(id: String): Flow<Result<Drink, GeneralError>> =
    drinkRepository.getById(id)

}