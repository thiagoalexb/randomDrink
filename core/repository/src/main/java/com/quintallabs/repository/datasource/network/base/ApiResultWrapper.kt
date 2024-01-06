package com.quintallabs.repository.datasource.network.base

import com.quintallabs.domain.models.commons.GeneralError
import com.quintallabs.domain.models.commons.Result

sealed class ApiResultWrapper<out T> {

  data class Success<out T>(val value: T) : ApiResultWrapper<T>()
  data class Error(val error: GeneralError) : ApiResultWrapper<Nothing>()
}

fun <I, O> ApiResultWrapper<I>.mapperToResult(mapper: (I) -> O): Result<O, GeneralError> {

  return when(this) {
    is ApiResultWrapper.Error -> {
      Result.Error(this.error)
    }
    is ApiResultWrapper.Success -> {
      Result.Success(mapper(this.value))
    }
  }

}