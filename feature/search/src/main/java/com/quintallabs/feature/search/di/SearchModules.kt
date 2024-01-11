package com.quintallabs.feature.search.di

import com.quintallabs.feature.search.presentation.detail.DrinkDetailViewModel
import com.quintallabs.feature.search.presentation.search.SearchViewModel
import org.koin.dsl.module

val searchModules = module {
    factory { SearchViewModel(get()) }
    factory { DrinkDetailViewModel(get(), get(), get()) }
}