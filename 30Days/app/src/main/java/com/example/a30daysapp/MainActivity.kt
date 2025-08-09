package com.example.a30daysapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
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