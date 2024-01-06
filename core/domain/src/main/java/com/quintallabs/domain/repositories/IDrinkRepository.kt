package com.quintallabs.domain.repositories

import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.models.commons.GeneralError
import com.quintallabs.domain.models.commons.Result
import kotlinx.coroutines.flow.Flow

interface IDrinkRepository {

  fun getRandomDrink(): Flow<Result<Drink, GeneralError>>

  fun searchDrink(query: String): Flow<Result<List<Drink>, GeneralError>>
}