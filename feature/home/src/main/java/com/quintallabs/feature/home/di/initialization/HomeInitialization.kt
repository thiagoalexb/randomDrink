package com.quintallabs.feature.home.di.initialization

import com.quintallabs.common.baseapp.di.modules.ModuleInitialization
import com.quintallabs.feature.home.di.homeModules
import org.koin.core.module.Module

class HomeInitialization : ModuleInitialization() {
  override fun init(): List<Module> {
    return listOf(
      homeModules
    )
  }
}