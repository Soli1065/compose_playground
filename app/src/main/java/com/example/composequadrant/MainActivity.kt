package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    ) {
                        Column {
                            Row {
                                QuadrantCard(title = "Text composable", description = "Displays text and follows the recommended Material Design guidelines.", color = Color(0xFFEADDFF))
                                QuadrantCard(title = "Image composable", description = "Creates a composable that lays out and draws a given Painter class object.", color = Color(0xFFD0BCFF))

                            }
                            Row {
                                QuadrantCard(title = "Row composable", description = "A layout composable that places its children in a horizontal sequence.", color = Color(0xFFB69DF8))
                                QuadrantCard(title = "Column composable", description = "A layout composable that places its children in a vertical sequence.", color = Color(0xFFF6EDFF))
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun QuadrantCard(title: String, description: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(color = color).padding(16.dp)

    ) {
        Text(text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(text = description,
            textAlign = TextAlign.Justify,
//            modifier = modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(modifier = Modifier.weight(1f).fillMaxWidth()) {
                QuadrantCard(title = stringResource(R.string.text_composable), description = "Displays text and follows the recommended Material Design guidelines.", color = Color(0xFFEADDFF), modifier = Modifier.weight(1f).fillMaxSize())
                QuadrantCard(title = stringResource(R.string.image_composable), description = "Creates a composable that lays out and draws a given Painter class object.", color = Color(0xFFD0BCFF), modifier = Modifier.weight(1f).fillMaxSize())

            }
            Row(modifier = Modifier.weight(1f).fillMaxWidth()) {
                QuadrantCard(title = stringResource(R.string.row_composable), description = "A layout composable that places its children in a horizontal sequence.", color = Color(0xFFB69DF8), modifier = Modifier.weight(1f).fillMaxSize())
                QuadrantCard(title = stringResource(R.string.column_composable), description = "A layout composable that places its children in a vertical sequence.", color = Color(0xFFF6EDFF), modifier = Modifier.weight(1f).fillMaxSize())
            }
        }
    }
}