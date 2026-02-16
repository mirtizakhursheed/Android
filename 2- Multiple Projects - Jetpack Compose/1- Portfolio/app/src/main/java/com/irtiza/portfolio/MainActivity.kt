package com.irtiza.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.irtiza.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortfolioTheme {
                Portfolio()
            }
        }
    }
}

@Composable
fun Portfolio() {
    val isOpen = remember { mutableStateOf(false) }
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 60.dp)
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)) {
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))
            Text(text = "Muhammad Irtiza Khurshid",
                style = TextStyle(color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold))
            Spacer(Modifier.height(8.dp))
            Text(text = "Android Compose Developer",
                style = MaterialTheme.typography.labelLarge)
            Spacer(Modifier.height(8.dp))
            Row {
                Image(painter = painterResource(id = R.drawable.instagram),contentDescription = null,
                    modifier = Modifier.size(18.dp))

                Text("/vision_android", style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(horizontal = 8.dp))

            }
            Spacer(Modifier.height(8.dp))
            Row {
                Image(painter = painterResource(id = R.drawable.github),contentDescription = null,
                    modifier = Modifier.size(18.dp))

                Text("/mirtizakhursheed", style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(horizontal = 8.dp))

            }
            Spacer(Modifier.height(8.dp))
            Button(onClick = {
                isOpen.value =  !isOpen.value
            }, shape = RectangleShape) {
                Text("My Projects")
            }

            if(isOpen.value) {
                Spacer(Modifier.height(8.dp))
                LazyColumn {
                    items(getProjectList()) { item ->

                        ProjectItem(item)
                    }
                }
            }

        }

    }
}

@Composable
fun ProjectItem(project: Project) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()) {
        Image(painter = painterResource(R.drawable.profile),
            modifier = Modifier.size(60.dp).clip(CircleShape),
            contentDescription = null)

        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = project.name, style = MaterialTheme.typography.labelLarge)
            Text(text = project.description, style = MaterialTheme.typography.labelMedium)
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

data class Project(val name: String, val description: String)

private fun getProjectList() = listOf<Project>(
    Project("Social Media App", "Connect with your friends"),
    Project("Media Player App", "Listen music endlessly"),
    Project("Gaming Media App", "Play famous games"),
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioTheme {
        Portfolio()
    }
}