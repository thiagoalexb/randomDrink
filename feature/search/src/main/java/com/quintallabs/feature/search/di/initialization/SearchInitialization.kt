package com.quintallabs.feature.search.di.initialization

import com.quintallabs.common.baseapp.di.modules.ModuleInitialization
import com.quintallabs.feature.search.di.searchModules
import org.koin.core.module.Module

class SearchInitialization : ModuleInitialization() {
  override fun init(): List<Module> {
    return listOf(
      searchModules
    )
  }
}