package hr.ferit.patrikcupic.labs.lab1

import androidx.annotation.DrawableRes

data class Recipe(
    @DrawableRes val image: Int,
    val title: String,
    val category: String,
    val cookingTime: Int, // u minutama
    val energy: Int, // u kalorijama
    val rating: Float,
    val description: String,
    val reviews: List<String>,
    val ingredients: List<Ingredient>
)