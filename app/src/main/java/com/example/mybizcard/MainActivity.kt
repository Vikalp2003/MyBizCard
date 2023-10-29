package com.example.mybizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybizcard.ui.theme.MyBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
//              colors = CardDefaults.cardColors(
//                containerColor = Color.Green,
//            ),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
        ) {
            Column(modifier=Modifier.height(300.dp),
//                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider()
                CreateInfo()
                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    },
//                    modifier = Modifier
//                        .height(300.dp)
//                        .width(200.dp)
//                        .padding(),
                    shape = RectangleShape,

                    ) {
                    Text(text = "Portfolio",
                        style = MaterialTheme.typography.labelLarge)
                }
                if(buttonClickedState.value){
                    Content()
                }else{
                    Box (){

                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color=Color.LightGray)
        ) {
            Portfolio(data = listOf(
                "Project 1",
                "Project 2",
                "Project 3",
                "Project 4"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(){
        items(data){ item ->
            Text(item)
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Vikalp Shinde",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Android Developer",
            modifier = Modifier.padding(4.dp)
        )

        Text(
            text = "#Devloper003",
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),

        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
//                color = MaterialTheme.colors.primary,
        tonalElevation = 4.dp,
        shadowElevation = 4.dp,
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}


//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBizCardTheme {

    }
}