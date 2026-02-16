package com.irtiza.a2_dollarcounterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.irtiza.a2_dollarcounterapp.ui.theme.DollarCounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DollarCounterAppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {
        DollarCounter()
    }
}

@Composable
fun DollarCounter() {
    val counter = remember { mutableIntStateOf(1) }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "$${counter.value *100}", style = MaterialTheme.typography.displayLarge)
        Spacer(Modifier.height(180.dp))

        ComposeButton {
            counter.intValue++
        }
    }
}

@Composable
fun ComposeButton(onClick :() -> Unit) {
    Card(modifier = Modifier.clip(CircleShape)
        .size(120.dp).clickable {
            onClick.invoke()
        }, shape = CircleShape, colors = CardDefaults.cardColors(
        containerColor = Color.Yellow
    )  ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Tap", style = MaterialTheme.typography.headlineLarge)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DollarCounterAppTheme {
        MyApp()
    }
}