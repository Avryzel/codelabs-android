package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.Place
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun PlaceDetailScreen(
    place: Place,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(place.imageRes),
            contentDescription = stringResource(place.nameRes),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(place.nameRes),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = stringResource(place.descRes),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PlaceDetailPreview() {
    MyCityTheme {
        Surface {
            PlaceDetailScreen(
                place = Place(
                    nameRes = R.string.historic_site_monas,
                    descRes = R.string.historic_site_monas_desc,
                    imageRes = R.drawable.ic_launcher_background
                )
            )
        }
    }
}