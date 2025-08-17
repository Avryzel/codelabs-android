package com.example.a30daysapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.model.Task
import com.example.a30daysapp.model.TasksDataSource
import com.example.a30daysapp.ui.theme._30DaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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
            items(TasksDataSource.tasks) { task ->
                TaskItem(tasks = task)
            }
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

@Composable
fun TaskItem(
    tasks: Task,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(bottom = 8.dp, start = 16.dp, end = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
        ) {
            TaskLabel(taskDay = tasks.dayRes)
            Spacer(Modifier.height(8.dp))
            TaskImage(taskImage = tasks.imageRes)
            Spacer(Modifier.height(8.dp))
            TaskInfo(taskTitle = tasks.titleRes, taskDesc = tasks.descriptionRes)
        }
    }
}

@Composable
fun TaskLabel(
    @StringRes taskDay: Int,
) {
    Text(
        text = stringResource(taskDay)
    )
}

@Composable
fun TaskImage(
    @DrawableRes taskImage: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .fillMaxWidth(),
        contentScale = ContentScale.Crop,
        painter = painterResource(taskImage),
        contentDescription = null
    )
}

@Composable
fun TaskInfo(
    @StringRes taskTitle: Int,
    @StringRes taskDesc: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(taskTitle)
        )
        Text(
            text = stringResource(taskDesc)
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LightPreview() {
    _30DaysAppTheme(darkTheme = false) {
        _30DaysApp()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DarkPreview() {
    _30DaysAppTheme(darkTheme = true) {
        _30DaysApp()
    }
}