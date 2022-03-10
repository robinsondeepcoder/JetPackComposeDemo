package tanti.rakshit.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tanti.rakshit.jetpackcomposedemo.ui.theme.JetPackComposeDemoTheme

class MainActivity : ComponentActivity() {

    var list = listOf("test", "test1", "test2", "test3")
    val myData = listOf("Hello,", "world!")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Greeting("Android")
                    LandingPage(myData)
                }
            }
        }
    }
}

/*
var isExpanded by remember { mutableStateOf(false) }

val boxColor: Color by animateColorAsState(
    if (isExpanded) Green else Yellow)
*/

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Composable
fun LandingPage(list: List<String>) {
    Scaffold(
        modifier = Modifier.fillMaxHeight(),
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.background,
                title = { Text("Title") },
                navigationIcon = {
                    IconButton(onClick = { /* Open Nav drawer */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { /* Navigate to Search fragment */ }) {
                        Icon(Icons.Filled.Search, contentDescription = null)
                    }
                    IconButton(onClick = { /* Navigate to About fragment */ }) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_foreground),
                            "icon description"
                        )
                    }
                },
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Tribalscale Blogs",
                    color = colors.secondary,
                    style = MaterialTheme.typography.h2
                )
                Spacer(Modifier.padding(vertical = 10.dp))



                LazyColumn {
                    items(list) { item ->
                        Text(text = item)
                    }
                }


                Box(
                    Modifier
                        .padding(horizontal = 10.dp)
                        // .width(360.dp)
                        .height(130.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(colors.secondary)
                    //  .clickable { isExpanded = !isExpanded }

                )
                {
                    Row(
                        Modifier.fillMaxHeight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .size(100.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            painter = painterResource(R.drawable.ic_launcher_foreground),
                            contentDescription = "Image description"

                        )
                        Column(Modifier.padding(end = 0.dp)) {
                            Text(
                                text = "Product",
                                style = MaterialTheme.typography.h4
                            )
                            Text(
                                modifier = Modifier.padding(all = 0.dp),
                                //  maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                                text = "Product Blogs that give insight into innovative global  products. \n - Blog 1 \n - Blog 2",
                                style = MaterialTheme.typography.body2,
                            )
                        }
                    }
                }
            }

        })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val myData = listOf("Hello,", "world!")

    JetPackComposeDemoTheme {
        // Greeting("Android")
        LandingPage(myData)
    }
}