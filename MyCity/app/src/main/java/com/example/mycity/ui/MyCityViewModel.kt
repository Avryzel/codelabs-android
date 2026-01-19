package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.Category
import com.example.mycity.data.MyCityUiState
import com.example.mycity.data.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState(isShowingListPage = true))
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun selectedCategory(selectedCategory: Category) {
        _uiState.update { currentState ->
            currentState.copy(
                currentCategory = selectedCategory,
                isShowingListPage = true,
                currentPlace = null
            )
        }
    }

    fun selectedPlace(selectedPlace: Place) {
        _uiState.update { currentState ->
            currentState.copy(
                currentPlace = selectedPlace,
                isShowingListPage = false
            )
        }
    }
}