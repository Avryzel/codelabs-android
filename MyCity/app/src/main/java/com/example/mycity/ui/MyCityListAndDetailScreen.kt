package com.example.mycity.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycity.data.Category
import com.example.mycity.data.Place

@Composable
private fun MyCityListAndDetail(
    category: Category,
    place: List<Place>,
    onClick: (Place) -> Unit,
    selectedPlace: Place,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Row(modifier = modifier) {
        PlaceScreen(
            places = place,
            onItemClick = onClick,
            modifier = Modifier.weight(2f)
        )
        PlaceDetailScreen(
            place = selectedPlace,
            modifier = Modifier.weight(3f)
        )
    }
}