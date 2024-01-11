package com.quintallabs.randomdrink

import android.app.Application
import com.quintallabs.common.baseapp.di.modules.ModuleInitializer
import io.paperdb.Paper
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RandomDrinkApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    initApplication()
  }

  private fun initApplication() {
    startKoin()
    startPaperDb()
  }

  private fun startKoin() {
    startKoin {
      androidContext(this@RandomDrinkApplication)
      modules(
        ModuleInitializer.modules
      )
    }
  }

  private fun startPaperDb() {
    Paper.init(this)
  }
}