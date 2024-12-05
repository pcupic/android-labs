package hr.ferit.patrikcupic.labs.lab1

import androidx.annotation.DrawableRes

data class Ingredient(
    @DrawableRes val image: Int,
    val title: String,
    val subtitle: String
)