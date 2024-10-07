package com.example.courses

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid(
                        modifier = Modifier.padding(
                            start = 8.dp,
                            top = 8.dp,
                            end = 8.dp
                        )
                    )
                }
            }
        }
    }
}
@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(DataSource.topics) {
            topic -> TopicCard(topic)
        }
    }
}
@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row {
            //Box {
                Image (
                    painter = painterResource(id = topic.imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f), //Define a proporção de largura e altura. nesse caso assegura que os lados vão ser do mesmo tamanho
                    contentScale = ContentScale.Crop //deixa a imagem no tamanho que tem disponivel, se precisar corta
                )
                Column{
                    Text (
                        text = stringResource(topic.nameId),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            top = 16.dp,
                            end = 16.dp,
                            bottom = 8.dp
                        )
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.ic_grain),
                            contentDescription = null,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        Text(
                            text = topic.availableCoursesId.toString(),
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }

        }
    }
//}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    CoursesTheme {
        TopicGrid(modifier = Modifier.padding(8.dp))
    }
}