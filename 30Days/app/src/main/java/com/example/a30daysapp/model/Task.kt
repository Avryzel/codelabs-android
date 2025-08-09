package com.example.a30daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Task(
    @StringRes val dayRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)