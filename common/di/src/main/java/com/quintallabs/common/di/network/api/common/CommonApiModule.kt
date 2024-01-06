package com.quintallabs.common.di.network.api.common

import com.quintallabs.repository.datasource.network.base.ApiUtil
import org.koin.dsl.module

val commonApiModule = module {
  factory { ApiUtil() }
}