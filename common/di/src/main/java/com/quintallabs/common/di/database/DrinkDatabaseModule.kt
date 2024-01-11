package com.quintallabs.common.di.database

import com.quintallabs.repository.datasource.db.DrinkDatabase
import org.koin.dsl.module

val drinkDatabaseModule = module {

  factory { DrinkDatabase() }
}