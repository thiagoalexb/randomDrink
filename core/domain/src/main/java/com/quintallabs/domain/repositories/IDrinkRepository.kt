package com.quintallabs.domain.repositories

import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.models.commons.GeneralError
import com.quintallabs.domain.models.commons.Result
import kotlinx.coroutines.flow.Flow

interface IDrinkRepository {

  fun getRandom(): Flow<Result<Drink, GeneralError>>

  fun search(query: String): Flow<Result<List<Drink>, GeneralError>>

  fun saveFavoritesDrinks(drinks: MutableList<Drink>)

  fun getFavorites(): MutableList<Drink>?

  fun getById(id: String): Flow<Result<Drink, GeneralError>>
}