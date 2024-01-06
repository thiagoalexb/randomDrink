package com.quintallabs.common.di.usecases

import com.quintallabs.domain.usecases.GetRandomDrinkUseCase
import org.koin.dsl.module

val drinkUseCaseModule = module {

  factory { GetRandomDrinkUseCase(get()) }
}