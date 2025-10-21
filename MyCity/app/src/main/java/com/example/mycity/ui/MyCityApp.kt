package com.example.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.R
import com.example.mycity.data.LocalDataProvider
import com.example.mycity.ui.theme.MyCityTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
            )
        }
    ) { innerPadding ->
        CategoryScreen(
            categories = LocalDataProvider.categories,
            onItemClick = {},
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MyCityAppPreview() {
    MyCityTheme {
        Surface {
            MyCityApp()
        }
    }
}