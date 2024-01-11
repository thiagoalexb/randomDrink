package com.quintallabs.feature.favorites.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.quintallabs.domain.models.Drink

data class FavoritesState(
  var isLoading: Boolean = false,
  var favorites: SnapshotStateList<Drink> = mutableStateListOf()
)