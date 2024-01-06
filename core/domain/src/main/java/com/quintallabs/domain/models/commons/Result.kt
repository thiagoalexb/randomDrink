package com.quintallabs.domain.models.commons


sealed class Result<out D, out E> {
  data class Success<D>(val data: D): Result<D, Nothing>()
  data class Error<E>(val error: E): Result<Nothing, E>()
}