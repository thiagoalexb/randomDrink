package com.quintallabs.repository.datasource.network

import com.quintallabs.core.data.dto.RandomDrinkResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApi {
  @GET("random.php")
  suspend fun getRandomDrink(): RandomDrinkResponseDTO

  @GET("filter.php?")
  suspend fun searchDrink(@Query("i") query: String): RandomDrinkResponseDTO

  @GET("lookup.php?")
  suspend fun getById(@Query("i") id: String): RandomDrinkResponseDTO
}