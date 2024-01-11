package com.quintallabs.common.di.repositories

import com.quintallabs.domain.repositories.IDrinkRepository
import com.quintallabs.repository.respositories.DrinkRepository
import org.koin.dsl.module

val drinkRepositoryModule = module{
  factory<IDrinkRepository> { DrinkRepository(get(), get(), get()) }
}