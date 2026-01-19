package com.example.mycity.data

data class MyCityUiState(
    val currentCategory: Category? = null,
    val currentPlace: Place? = null,
    val isShowingListPage: Boolean = true
)