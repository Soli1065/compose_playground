package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.fillMaxSize().background(Color(0xFF3ddc84)).padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        MainComposable()
                        Spacer(modifier = Modifier.weight(1f))
                        FooterComposable()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun MainComposable() {
    val androidLogo = painterResource(R.drawable.android_logo)
    Column(
//        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = androidLogo,
            contentDescription = null,
            modifier = Modifier.padding(16.dp).background(color = Color(0xFF073042)).size(150.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Salman Hosseini",
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 8.dp),
            textAlign = TextAlign.Center,
        )
        Text(
            text = "Android Developer",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color(0xFF1A7347),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

        )

    }
}


@Composable
fun FooterComposable() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start
        ) {
            FooterElement(imageVector = Icons.Rounded.Call, text = "+1 (437) 219 4089")
            FooterElement(imageVector = Icons.Rounded.Share, text = "In: Salman-Hosseini")
            FooterElement(imageVector = Icons.Rounded.Email, text = "S.hosseini.309@gmail.com")

        }
    }
}

@Composable
fun FooterElement(imageVector: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,

    ) {
        Icon(imageVector, contentDescription = null, tint = Color(0xFF1A7347))
        Spacer(modifier = modifier.width(16.dp))
        Text(
            text = text,
            color = Color(0xFF1A7347),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
        )


    }
}



@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFF3ddc84)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            MainComposable()
            Spacer(modifier = Modifier.weight(1f))
            FooterComposable()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FooterComposablePreview() {
    BusinessCardTheme {
        FooterComposable()

    }
}