package com.quintallabs.common.di.network.api

import com.quintallabs.repository.datasource.network.DrinkApi
import org.koin.dsl.module
import retrofit2.Retrofit

fun provideLDrinkApi(retrofit: Retrofit): DrinkApi =
  retrofit.create(DrinkApi::class.java)

val drinkApiModule = module {
  factory {
    provideLDrinkApi(get())
  }
}