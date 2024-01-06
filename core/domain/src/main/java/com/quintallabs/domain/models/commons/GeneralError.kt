package com.quintallabs.domain.models.commons

data class GeneralError(
  val title: String,
  val detail: String,
  val code: Int
)