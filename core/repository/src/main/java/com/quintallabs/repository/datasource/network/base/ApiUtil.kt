package com.quintallabs.repository.datasource.network.base

import com.quintallabs.domain.models.commons.GeneralError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class ApiUtil {

  suspend fun <I> safeApiCall(
    apiCall: suspend () -> I
  ): ApiResultWrapper<I> {

    return withContext(Dispatchers.IO) {
      try {
        ApiResultWrapper.Success(apiCall.invoke())
      } catch (throwable: Throwable) {
        when (throwable) {
          is HttpException -> {

            when (throwable.code()) {
              500 -> {
                ApiResultWrapper.Error(
                  GeneralError(
                    title = "Server error",
                    detail = throwable.message(),
                    code = 500,
                  )
                )
              }

              401 -> {
                ApiResultWrapper.Error(
                  GeneralError(
                    title = "Request error",
                    detail = throwable.message(),
                    code = 401,
                  )
                )
              }

              else -> {
                ApiResultWrapper.Error(
                  GeneralError(
                    title = "Unknown error",
                    detail = throwable.message(),
                    code = throwable.code(),
                  )
                )
              }
            }
          }

          else -> {
            ApiResultWrapper.Error(
              GeneralError(
                title = "Unknown error",
                detail = throwable.message.toString(),
                code = 0,
              )
            )
          }
        }
      }
    }
  }
}