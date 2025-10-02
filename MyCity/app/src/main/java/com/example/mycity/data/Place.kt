package com.example.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    @StringRes val nameRes: Int,
    @StringRes val descRes: Int,
    @DrawableRes val imageRes: Int
)