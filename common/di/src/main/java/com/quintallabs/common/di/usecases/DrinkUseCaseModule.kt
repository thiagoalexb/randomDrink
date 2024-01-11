package com.quintallabs.common.di.usecases

import com.quintallabs.domain.usecases.GetDrinkByIdUseCase
import com.quintallabs.domain.usecases.GetFavoritesDrinksUseCase
import com.quintallabs.domain.usecases.GetRandomDrinkUseCase
import com.quintallabs.domain.usecases.SaveFavoritesDrinksUseCase
import com.quintallabs.domain.usecases.SearchDrinkUseCase
import org.koin.dsl.module

val drinkUseCaseModule = module {

  factory { GetRandomDrinkUseCase(get()) }
  factory { SaveFavoritesDrinksUseCase(get()) }
  factory { GetFavoritesDrinksUseCase(get()) }
  factory { SearchDrinkUseCase(get()) }
  factory { GetDrinkByIdUseCase(get()) }
}