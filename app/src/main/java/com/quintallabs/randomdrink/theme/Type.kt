package com.quintallabs.randomdrink.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.quintallabs.randomdrink.R

val Roboto = FontFamily(
  Font(R.font.roboto_light, FontWeight.Light),
  Font(R.font.roboto_regular, FontWeight.Normal),
  Font(R.font.roboto_medium, FontWeight.Medium),
  Font(R.font.roboto_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
private val defaultTypography = Typography()
val Typography = Typography(
  displayLarge = defaultTypography.displayLarge.copy(fontFamily = Roboto),
  displayMedium = defaultTypography.displayMedium.copy(fontFamily = Roboto),
  displaySmall = defaultTypography.displaySmall.copy(fontFamily = Roboto),
  headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = Roboto),
  headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = Roboto),
  headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = Roboto),
  titleLarge = defaultTypography.titleLarge.copy(fontFamily = Roboto),
  titleMedium = defaultTypography.titleMedium.copy(fontFamily = Roboto),
  titleSmall = defaultTypography.titleSmall.copy(fontFamily = Roboto),
  bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = Roboto),
  bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = Roboto),
  bodySmall = defaultTypography.bodySmall.copy(fontFamily = Roboto),
  labelLarge = defaultTypography.labelLarge.copy(fontFamily = Roboto),
  labelMedium = defaultTypography.labelMedium.copy(fontFamily = Roboto),
  labelSmall = defaultTypography.labelSmall.copy(fontFamily = Roboto)
)