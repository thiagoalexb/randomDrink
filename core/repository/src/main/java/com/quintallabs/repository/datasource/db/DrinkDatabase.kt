package com.quintallabs.repository.datasource.db

import com.quintallabs.domain.models.Drink
import io.paperdb.Paper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

private const val FAVORITES = "FAVORITES"

class DrinkDatabase {
  fun saveFavorite(drinks: MutableList<Drink>) {
    Paper.book().write(FAVORITES, drinks)
  }

  fun getFavorites(): MutableList<Drink>? {
    return Paper.book().read<MutableList<Drink>>(FAVORITES, mutableListOf())
  }

  fun getFlowFavorites(): Flow<MutableList<Drink>?> = flow {
    val read = Paper.book().read<MutableList<Drink>>(FAVORITES, mutableListOf())
    emit(read)
  }
}