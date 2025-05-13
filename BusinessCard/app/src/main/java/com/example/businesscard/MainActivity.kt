package com.example.businesscard

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize().background(color = Color(0xFFEAF8E6)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            NameCard()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 42.dp),
            contentAlignment = Alignment.Center
        ) {
            ContactCard()
        }
    }
}

@Composable
fun NameCard() {
    val image = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "Android Logo",
            Modifier
                .size(70.dp)
                .background(color = Color.Black)
        )
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(R.string.title),
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun ContactCard() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row {
            Icon(
                Icons.Rounded.Call,
                contentDescription = null,
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.phone_number),
            )
        }
        Spacer(
            Modifier.height(8.dp)
        )
        Row {
            Icon(
                Icons.Rounded.Share,
                contentDescription = null,
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.social_media)
            )
        }
        Spacer(
            Modifier.height(8.dp)
        )
        Row {
            Icon(
                Icons.Rounded.Email,
                contentDescription = null
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.email)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}