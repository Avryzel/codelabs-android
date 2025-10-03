package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.Category
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun MyCityApp() {

}

@Composable
private fun CategoryListItem(
    category: Painter,
    onItemClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = stringResource(R.string.category_historic_sites)
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
                category = painterResource(R.drawable.ic_launcher_background),
                onItemClick = {}
            )

        }
    }
}