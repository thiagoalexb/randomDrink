package com.quintallabs.core.data.dto

import com.google.gson.annotations.SerializedName

data class DrinkDTO(
  val idDrink: String,
  val strDrink: String,
  val strDrinkAlternate: String?,
  val strTags: String?,
  val strVideo: String?,
  val strCategory: String,
  @SerializedName("strIBA")
  val strIba: String?,
  val strAlcoholic: String,
  val strGlass: String,
  val strInstructions: String,
  @SerializedName("strInstructionsES")
  val strInstructionsEs: String?,
  @SerializedName("strInstructionsDE")
  val strInstructionsDe: String?,
  @SerializedName("strInstructionsFR")
  val strInstructionsFr: String?,
  @SerializedName("strInstructionsIT")
  val strInstructionsIt: String?,
  @SerializedName("strInstructionsZH-HANS")
  val strInstructionsZhHans: String?,
  @SerializedName("strInstructionsZH-HANT")
  val strInstructionsZhHant: String?,
  val strDrinkThumb: String,
  val strIngredient1: String?,
  val strIngredient2: String?,
  val strIngredient3: String?,
  val strIngredient4: String?,
  val strIngredient5: String?,
  val strIngredient6: String?,
  val strIngredient7: String?,
  val strIngredient8: String?,
  val strIngredient9: String?,
  val strIngredient10: String?,
  val strIngredient11: String?,
  val strIngredient12: String?,
  val strIngredient13: String?,
  val strIngredient14: String?,
  val strIngredient15: String?,
  val strMeasure1: String?,
  val strMeasure2: String?,
  val strMeasure3: String?,
  val strMeasure4: String?,
  val strMeasure5: String?,
  val strMeasure6: String?,
  val strMeasure7: String?,
  val strMeasure8: String?,
  val strMeasure9: String?,
  val strMeasure10: String?,
  val strMeasure11: String?,
  val strMeasure12: String?,
  val strMeasure13: String?,
  val strMeasure14: String?,
  val strMeasure15: String?,
  val strImageSource: String?,
  val strImageAttribution: String?,
  val strCreativeCommonsConfirmed: String?,
  val dateModified: String?,
)