package com.quintallabs.repository.datasource.network

import com.quintallabs.core.data.dto.RandomDrinkResponseDTO
import retrofit2.http.GET

interface DrinkApi {
  @GET("random.php")
  suspend fun getRandomDrink(): RandomDrinkResponseDTO

  @GET("region/europe")
  suspend fun searchDrink(query: String)
}