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
import com.example.mycity.data.Category
import com.example.mycity.data.Place
import com.example.mycity.ui.theme.MyCityTheme

@Composable
private fun CategoryListItem(
    category: Category,
    onItemClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        onClick = { onItemClick(category) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(category.places.first().imageRes),
                contentDescription = stringResource(category.nameRes),
                alignment = Alignment.Center,
                modifier = Modifier.size(64.dp)
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = stringResource(category.nameRes),
                textAlign = TextAlign.Start,
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun CategoryListItemPreview() {
    MyCityTheme {
        Surface {
            CategoryListItem(
                category = Category(
                    nameRes = R.string.category_historic_sites,
                    places = listOf(
                        Place(
                            nameRes = R.string.historic_site_monas,
                            descRes = R.string.historic_site_monas_desc,
                            imageRes = R.drawable.ic_launcher_background
                        )
                    )
                ),
                onItemClick = {}
            )

        }
    }
}