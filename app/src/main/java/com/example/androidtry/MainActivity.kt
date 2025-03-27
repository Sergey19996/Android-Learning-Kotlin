package com.example.androidtry

import android.graphics.pdf.models.ListItem
import android.icu.text.ListFormatter.Width
import android.os.Bundle
import android.provider.MediaStore.Video
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidtry.ui.theme.AndroidTryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        val people = listOf(
//            Person("DJ","Mallone",25),
//            Person("DJU","Mallone",32),
//            Person("DJB","Kura",41),
//            Person("DJZ","ARUK",12),
//
//        )
      //  val peopleFiltered = people.filter{it.age > 21 }
val rsssItems = listOf(
    RSSItem("Welcome to Austin, Texas, We have music!", "music is nice when is on",RSSType.TEXT),
    RSSItem("Welcome to my photo gallery,\nView photos!", "click here for gallery",RSSType.IMAGE,R.drawable.dungeonmap),
    RSSItem("Welcome to my blog!", "awdawdaw awdawda",RSSType.VIDEO,R.drawable.plates),



    )

        setContent {
            AndroidTryTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color(91,96,92))
                { innerPadding ->
                    LazyColumn(modifier = Modifier.padding(innerPadding)) {
                        items(rsssItems){
                            when (it.type) {
                                RSSType.VIDEO -> {
                                    RSSItemVideo(it)
                                }
                                RSSType.TEXT -> {
                                    RSSItemText(it)

                                }
                                else -> {
                                    RSSItemImage(it)

                                }
                            }

                        }

                    }
                }
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


        Text(text = "Not Hello $name!",
             modifier = modifier

              //  .padding(bottom = 16.dp,end = 10.dp)
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
fun CardView(person: Person) {
    Card(modifier = Modifier.fillMaxSize().padding((32.dp)))
    {
        Row {
            Image(painter = painterResource(id = R.drawable.baseline_person_24) ,
                contentDescription ="Photo of person",
                modifier = Modifier.width(100.dp).height(120.dp).background(color = Color.White))
            Column {
                Text(text = "First name: " +person.firstName,modifier = Modifier.padding(0.dp))
                Text(text = "Last name: " +person.lastName,modifier = Modifier.padding(0.dp))
                Text(text = "Age: " + person.age,modifier = Modifier.padding(0.dp))
            }
        }

    }

}
@Composable
fun RSSItemText(itRSSItem: RSSItem){
Card(modifier =  Modifier.fillMaxSize().padding(top = 32.dp).padding(32.dp)) {
    Text(text = itRSSItem.title,
        fontSize =  22.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.Black,
        modifier = Modifier.padding(12.dp)
        )
    Text(text = itRSSItem.text,
        modifier = Modifier.padding(12.dp)
    )


}



}
@Composable
fun RSSItemVideo(itRSSItem: RSSItem){
    Card(modifier =  Modifier.fillMaxSize().padding( 32.dp)) {
        Column {
            Text(text ="Click Below to play Video :\n" , modifier =  Modifier.padding(12.dp) )

            itRSSItem.media?.let {


            Image(painter = painterResource(id = it),
                contentDescription = "Photo of person",
                modifier = Modifier.fillMaxSize().padding(32.dp))

            }
        }




    }



}
@Composable
fun RSSItemImage(itRSSItem: RSSItem){
    Card(modifier =  Modifier.padding(top = 32.dp).padding(32.dp)) {

            Text(text = itRSSItem.title,

                lineHeight =  32.sp,
                fontWeight = FontWeight.Black,
                fontSize = 22.sp,
                modifier = Modifier.clickable {
                    Log.d("DJMALONE","photo tapped!")
                }

            )
        itRSSItem.media?.let {


            Image(
                painter = painterResource(id = it),
                contentDescription = "Photo of person",
                modifier = Modifier.fillMaxSize().padding(12.dp),

                )

        }





    }



}





