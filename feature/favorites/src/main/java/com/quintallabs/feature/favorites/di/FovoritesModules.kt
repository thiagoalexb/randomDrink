package com.quintallabs.feature.favorites.di

import com.quintallabs.feature.favorites.presentation.FavoritesViewModel
import org.koin.dsl.module

val favoritesModules = module {
    factory { FavoritesViewModel(get(), get()) }
}