package com.quintallabs.repository.respositories

import com.quintallabs.common.extensions.mappers.toDrink
import com.quintallabs.domain.models.Drink
import com.quintallabs.domain.models.commons.GeneralError
import com.quintallabs.domain.models.commons.Result
import com.quintallabs.domain.repositories.IDrinkRepository
import com.quintallabs.repository.datasource.network.DrinkApi
import com.quintallabs.repository.datasource.network.base.ApiResultWrapper
import com.quintallabs.repository.datasource.network.base.ApiUtil
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DrinkRepository(
  private val apiUtil: ApiUtil,
  private val drinkApi: DrinkApi,
) : IDrinkRepository {

  override fun getRandomDrink(): Flow<Result<Drink, GeneralError>> = flow {
    val call = apiUtil.safeApiCall {
      drinkApi.getRandomDrink()
    }

    when (call) {
      is ApiResultWrapper.Error -> {
        emit(
          Result.Error(call.error)
        )
      }

      is ApiResultWrapper.Success -> {
        val drinks = call.value.drinks

        emit(Result.Success(drinks.first().toDrink()))
      }
    }
  }

  override fun searchDrink(query: String): Flow<Result<List<Drink>, GeneralError>> {
    TODO()
  }
}