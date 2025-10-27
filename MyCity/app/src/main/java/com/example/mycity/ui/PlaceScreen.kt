package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.Place
import com.example.mycity.ui.theme.MyCityTheme

@Composable
private fun PlaceListItem(
    place: Place,
    onItemClick: (Place) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        onClick = { onItemClick(place) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(place.imageRes),
                contentDescription = stringResource(place.nameRes),
                alignment = Alignment.Center,
                modifier = Modifier.size(64.dp)
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = stringResource(place.nameRes),
                textAlign = TextAlign.Start,
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PlaceListItemPreview() {
    MyCityTheme {
        Surface {
            PlaceListItem(
                place = Place(
                    nameRes = R.string.historic_site_monas,
                    imageRes = R.drawable.ic_launcher_background,
                    descRes = R.string.historic_site_monas_desc
                ),
                onItemClick = {}
            )
        }
    }
}