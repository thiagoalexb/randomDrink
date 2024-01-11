package com.quintallabs.feature.home.di

import com.quintallabs.feature.home.presentation.HomeViewModel
import org.koin.dsl.module

val homeModules = module {
  factory { HomeViewModel(get(), get(), get()) }
}