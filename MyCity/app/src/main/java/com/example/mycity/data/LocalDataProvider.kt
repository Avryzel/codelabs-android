package com.example.mycity.data

import androidx.compose.ui.res.stringResource
import com.example.mycity.R

object LocalDataProvider {
    val categories: List<Category> = listOf(
        Category(
            nameRes = R.string.category_historic_sites,
            places = listOf(

            )
        ),
        Category(
            nameRes = R.string.category_street_food,
            places = listOf(

            )
        ),
        Category(
            nameRes = R.string.category_shopping_malls,
            places = listOf(

            )
        ),
        Category(
            nameRes = R.string.category_train_stations,
            places = listOf(

            )
        )
    )
}