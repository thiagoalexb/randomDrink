package com.quintallabs.common.extensions.mappers

import com.quintallabs.domain.models.Drink
import com.quintallabs.core.data.dto.DrinkDTO

fun DrinkDTO.toDrink(): Drink {
  return Drink(
    id = this.idDrink,
    drinkName = this.strDrink,
    drinkAlternative = this.strDrinkAlternate,
    tags = getTags(this.strTags),
    videoUrl = this.strVideo,
    category = this.strCategory,
    iba = this.strIba,
    alcoholic = this.strAlcoholic,
    glassType = this.strGlass,
    instructions = this.strInstructions,
    drinkThumb = this.strDrinkThumb,
    ingredients = getIngredients(this),
    imageUrl = this.strImageSource,
    imageAttribution = this.strImageAttribution,
    dateModified = this.dateModified,
  )
}

private fun getTags(tags: String?): List<String> {
  if(tags == null) return emptyList()

  return tags.split(",")
}

private fun getIngredients(drink: DrinkDTO): List<Pair<String, String>> {
  val ingredients = mutableListOf<Pair<String, String>>()
  ingredients.add(Pair(drink.strIngredient1 ?: "", drink.strMeasure1 ?: ""))
  ingredients.add(Pair(drink.strIngredient2 ?: "", drink.strMeasure2 ?: ""))
  ingredients.add(Pair(drink.strIngredient3 ?: "", drink.strMeasure3 ?: ""))
  ingredients.add(Pair(drink.strIngredient4 ?: "", drink.strMeasure4 ?: ""))
  ingredients.add(Pair(drink.strIngredient5 ?: "", drink.strMeasure5 ?: ""))
  ingredients.add(Pair(drink.strIngredient6 ?: "", drink.strMeasure6 ?: ""))
  ingredients.add(Pair(drink.strIngredient7 ?: "", drink.strMeasure7 ?: ""))
  ingredients.add(Pair(drink.strIngredient8 ?: "", drink.strMeasure8 ?: ""))
  ingredients.add(Pair(drink.strIngredient9 ?: "", drink.strMeasure9 ?: ""))
  ingredients.add(Pair(drink.strIngredient10 ?: "", drink.strMeasure10 ?: ""))
  ingredients.add(Pair(drink.strIngredient11 ?: "", drink.strMeasure11 ?: ""))
  ingredients.add(Pair(drink.strIngredient12 ?: "", drink.strMeasure12 ?: ""))
  ingredients.add(Pair(drink.strIngredient13 ?: "", drink.strMeasure13 ?: ""))
  ingredients.add(Pair(drink.strIngredient14 ?: "", drink.strMeasure14 ?: ""))
  ingredients.add(Pair(drink.strIngredient15 ?: "", drink.strMeasure15 ?: ""))

  return ingredients.filter { it.first.isNotBlank() }
}