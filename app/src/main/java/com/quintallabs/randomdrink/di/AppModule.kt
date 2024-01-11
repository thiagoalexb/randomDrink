package com.quintallabs.randomdrink.di

import com.quintallabs.common.baseapp.di.modules.ModuleInitialization
import com.quintallabs.common.di.database.drinkDatabaseModule
import com.quintallabs.common.di.network.api.common.commonApiModule
import com.quintallabs.common.di.network.api.drinkApiModule
import com.quintallabs.common.di.network.networkModule
import com.quintallabs.common.di.repositories.drinkRepositoryModule
import com.quintallabs.common.di.usecases.drinkUseCaseModule
import org.koin.core.module.Module

class AppModule : ModuleInitialization() {

  override fun init(): List<Module> {
    val listModules = mutableListOf<Module>()

    listModules.addAll(getNetworkModules())
    listModules.addAll(getDrinkModules())
    listModules.addAll(getApiCommonModules())

    return listModules
  }

  private fun getNetworkModules(): List<Module> {
    return listOf(
      networkModule
    )
  }

  private fun getDrinkModules(): List<Module> {
    return listOf(
      drinkUseCaseModule,
      drinkRepositoryModule,
      drinkApiModule,
      drinkDatabaseModule
    )
  }

  private fun getApiCommonModules(): List<Module> {
    return listOf(
      commonApiModule
    )
  }

}