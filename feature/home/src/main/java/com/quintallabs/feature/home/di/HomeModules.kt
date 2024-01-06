package com.quintallabs.feature.home.di

import com.quintallabs.feature.home.ui.HomeViewModel
import org.koin.dsl.module

val homeModules = module {
  factory { HomeViewModel(get()) }
}