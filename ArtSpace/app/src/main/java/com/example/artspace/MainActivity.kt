package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var pageIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when(pageIndex) {
                0 -> {
                    ArtworkWall(imageRes = R.drawable.mogoon_art01)
                    Spacer(modifier = Modifier.height(24.dp))
                    ArtworkDescriptor(
                        titleRes = R.string.artwork_title01,
                        artistRes = R.string.artwork_artist01,
                        yearRes = R.string.artwork_made01
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    DisplayController()
                }
                1 -> {
                    ArtworkWall(imageRes = R.drawable.mogoon_art01)
                    Spacer(modifier = Modifier.height(24.dp))
                    ArtworkDescriptor(
                        titleRes = R.string.artwork_title01,
                        artistRes = R.string.artwork_artist01,
                        yearRes = R.string.artwork_made01
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    DisplayController()
                }
                2 -> {
                    ArtworkWall(imageRes = R.drawable.mogoon_art01)
                    Spacer(modifier = Modifier.height(24.dp))
                    ArtworkDescriptor(
                        titleRes = R.string.artwork_title01,
                        artistRes = R.string.artwork_artist01,
                        yearRes = R.string.artwork_made01
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    DisplayController()
                }
                else -> {
                    ArtworkWall(imageRes = R.drawable.mogoon_art01)
                    Spacer(modifier = Modifier.height(24.dp))
                    ArtworkDescriptor(
                        titleRes = R.string.artwork_title01,
                        artistRes = R.string.artwork_artist01,
                        yearRes = R.string.artwork_made01
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    DisplayController()
                }
            }
        }
    }
}

@Composable
fun ArtworkWall(imageRes: Int) {
    val image = painterResource(imageRes)

    Box(
        modifier = Modifier
            .background(Color.LightGray)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(32.dp)
        )
    }
}

@Composable
fun ArtworkDescriptor(
    titleRes: Int,
    artistRes: Int,
    yearRes: Int
) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFE0E0E0))
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(titleRes),
                fontSize = 32.sp,
                fontWeight = FontWeight.W200,
            )
            Row {
                Text(
                    text = stringResource(artistRes),
                    fontWeight = FontWeight.Bold

                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(yearRes),
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}

@Composable
fun DisplayController() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .widthIn(max = 400.dp)
            .fillMaxWidth()
    ) {
        Button(
            onClick = {},
            modifier = Modifier.width(150.dp)
        ) {
            Text(stringResource(R.string.previous_button))
        }
        Spacer(
            modifier = Modifier.width(32.dp)
        )
        Button(
            onClick = {},
            modifier = Modifier.width(150.dp)
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