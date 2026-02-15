package com.example.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.R
import com.example.mycity.data.Category
import com.example.mycity.data.LocalDataProvider
import com.example.mycity.utils.MyCityContentType
import com.example.mycity.utils.MyCityNavigationType

enum class MyAppScreen(@StringRes val title: Int, val icon: ImageVector) {
    Category(title = R.string.app_name, icon = Icons.AutoMirrored.Filled.List),
    Place(title = R.string.choose_place, icon = Icons.AutoMirrored.Filled.List),
    Detail(title = R.string.place_detail, icon = Icons.AutoMirrored.Filled.List)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    currentScreen: MyAppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,

        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }

        }
    )
}

@Composable
private fun MyCityBottomNavBar(
    currentScreen: MyAppScreen,
    onTabSelected: (MyAppScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    val topLevelDestination = listOf(MyAppScreen.Category)

    NavigationBar(windowInsets = NavigationBarDefaults.windowInsets, modifier = modifier) {
        topLevelDestination.forEach { screen ->
            NavigationBarItem(
                selected = currentScreen == screen,
                onClick = {
                    onTabSelected(screen)
                },
                label = { Text(stringResource(screen.title)) },
                icon = { Icon(imageVector = screen.icon, contentDescription = null) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    viewModel: MyCityViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    windowsSize: WindowWidthSizeClass
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = MyAppScreen.valueOf(
        backStackEntry?.destination?.route ?: MyAppScreen.Category.name
    )

    val navigationType: MyCityNavigationType
    val contentType: MyCityContentType

    when (windowsSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = MyCityNavigationType.BOTTOM_NAVIGATION
            contentType = MyCityContentType.ListOnly
        }

        WindowWidthSizeClass.Medium -> {
            navigationType = MyCityNavigationType.NAVIGATION_RAIL
            contentType = MyCityContentType.ListOnly
        }

        WindowWidthSizeClass.Expanded -> {
            navigationType = MyCityNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = MyCityContentType.ListAndDetail
        }

        else -> {
            navigationType = MyCityNavigationType.BOTTOM_NAVIGATION
            contentType = MyCityContentType.ListOnly
        }
    }

    Scaffold(
        topBar = {
            MyCityAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,

                navigateUp = { navController.navigateUp() }
            )
        },
        bottomBar = {
            if (navigationType == MyCityNavigationType.BOTTOM_NAVIGATION) {
                MyCityBottomNavBar(
                    currentScreen = currentScreen,
                    onTabSelected = { screen ->
                        navController.navigate(screen.name)
                    }
                )
            }
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MyAppScreen.Category.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = MyAppScreen.Category.name) {
                CategoryScreen(
                    categories = LocalDataProvider.categories,
                    onItemClick = { category ->
                        viewModel.selectedCategory(category)
                        navController.navigate(MyAppScreen.Place.name)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(route = MyAppScreen.Place.name) {
                val currentPlace = uiState.currentCategory?.places ?: listOf()

                PlaceScreen(
                    places = currentPlace,
                    onItemClick = { place ->
                        viewModel.selectedPlace(place)
                        navController.navigate(MyAppScreen.Detail.name)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(route = MyAppScreen.Detail.name) {
                val selectedPlace = uiState.currentPlace

                if (selectedPlace != null) {
                    PlaceDetailScreen(
                        place = selectedPlace,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}