package com.example.a30daysapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysapp.ui.theme._30DaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    _30DaysApp()
                }
            }
        }
    }
}

@SuppressLint("ComposableNaming")
@Composable
fun _30DaysApp() {
    Scaffold(
        topBar = { _30DaysTopBar() }
    ) { it ->
        LazyColumn(contentPadding = it) {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ComposableNaming")
@Composable
fun _30DaysTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "30 Days Of Japanese"
            )
        }
    )
}

@SuppressLint("ComposableNaming")
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun _30DaysAppPreview() {
    _30DaysAppTheme {
        _30DaysApp()
    }
}