package com.quintallabs.feature.home.ui

sealed class HomeEvent {
  object OnReload: HomeEvent()
}