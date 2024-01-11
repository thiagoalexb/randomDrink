package com.quintallabs.feature.favorites.di.initialization

import com.quintallabs.common.baseapp.di.modules.ModuleInitialization
import com.quintallabs.feature.favorites.di.favoritesModules
import org.koin.core.module.Module

class FavoritesInitialization : ModuleInitialization() {
  override fun init(): List<Module> {
    return listOf(
      favoritesModules
    )
  }
}