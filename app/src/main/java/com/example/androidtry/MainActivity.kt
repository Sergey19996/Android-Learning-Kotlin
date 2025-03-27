package com.example.androidtry

import android.graphics.pdf.models.ListItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidtry.ui.theme.AndroidTryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val people = listOf("John", "Jack", "DJ", "Luke","John", "Jack", "DJ", "Luke","John", "Jack", "DJ", "Luke","John", "Jack", "DJ", "Luke")


        setContent {
            AndroidTryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(name = "Android", modifier = Modifier.padding(innerPadding))
                    LazyColumn {
                        items(people){
                        ListItem(it)
                        }

                    }
                }
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Not Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidTryTheme {
        Greeting("Android")
    }
}
@Composable
fun ListItem(name: String) {
    Card(modifier = Modifier.fillMaxSize().padding((32.dp)))
    {
        Row {
            Image(painter = painterResource(id = R.drawable.baseline_person_24) ,
                contentDescription ="Photo of person",
                modifier = Modifier.width(100.dp).height(100.dp).background(color = Color.Gray))
            Text(text = name,modifier = Modifier.padding(32.dp))
        }

    }

}
