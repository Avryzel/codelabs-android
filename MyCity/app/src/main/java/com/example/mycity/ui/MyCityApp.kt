package com.example.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.R
import com.example.mycity.data.LocalDataProvider
import com.example.mycity.data.Place

enum class MyAppScreen {
    Category,
    Place,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    viewModel: MyCityViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MyAppScreen.Category.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyAppScreen.Category.name) {
                CategoryScreen(
                    categories = LocalDataProvider.categories,
                    onItemClick = {},
                )
            }

            composable(route = MyAppScreen.Place.name) {
                val currentPlace = uiState.currentCategory?.places ?: listOf()

                PlaceScreen(
                    places = currentPlace,
                    onItemClick = {}
                )
            }

            composable(route = MyAppScreen.Detail.name) {
                val selectedPlace = uiState.currentPlace

                if (selectedPlace != null) {
                    PlaceDetailScreen(
                        place = selectedPlace,
                    )
                }
            }
        }
    }
}