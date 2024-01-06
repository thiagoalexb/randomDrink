package com.quintallabs.common.di.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
private const val CACHE_SIZE_10_MB = 10 * 1024 * 1024
private const val TIMEOUT: Long = 60
private const val CHILD_PATH: String = "responses"

val networkModule = module {

  single {
    val cacheSize = CACHE_SIZE_10_MB
    val httpCacheDirectory = File(androidApplication().cacheDir, CHILD_PATH)
    val cache = Cache(httpCacheDirectory, cacheSize.toLong())

    cache
  }

  single {
    OkHttpClient.Builder()
      .cache(get())
      .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
      .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
      .readTimeout(TIMEOUT, TimeUnit.SECONDS)
      .build()
  }

  single {
    CoroutineCallAdapterFactory()
  }

  single<Retrofit> {
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(get())
      .build()
  }
}