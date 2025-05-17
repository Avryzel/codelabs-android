package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ArtworkWall()
        ArtworkDescriptor()
        Spacer(modifier = Modifier.height(32.dp))
        DisplayController()
    }
}

@Composable
fun ArtworkWall() {
    val image = painterResource(R.drawable.mogoon_art01)

    Image(
        painter = image,
        contentDescription = "モ誰 Art",
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp)
    )
}

@Composable
fun ArtworkDescriptor() {
    Column {
        Text(
            text = stringResource(R.string.artwork_title01)
        )
        Text(
            text = stringResource(R.string.artwork_artist01)
        )
    }
}

@Composable
fun DisplayController() {
    Row {
        Button(
            onClick = {}
        ) {
            Text(stringResource(R.string.previous_button))
        }
        Spacer(modifier = Modifier.width(20.dp))
        Button(
            onClick = {}
        ) {
            Text(stringResource(R.string.next_button))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}