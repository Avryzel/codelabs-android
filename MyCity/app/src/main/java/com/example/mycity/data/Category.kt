package com.example.mycity.data

import androidx.annotation.StringRes

data class Category(
    @StringRes val nameRes: Int,
    val places: List<Place>
)