package com.example.inlamning2androidpia12

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inlamning2androidpia12.ui.theme.Inlamning2AndroidPia12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Inlamning2AndroidPia12Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MinApp()
                }
            }
        }
    }
}

@Composable
fun MinApp() {
    val listItems = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(onXClicked = { listItems.add("X")}, onYClicked = { listItems.add("Y") })
        ItemList(listItems)
        Spacer(modifier = Modifier.weight(1F))
        ResetButton { listItems.clear() }
    }
}

@Composable
fun TopBar(onXClicked : () -> Unit, onYClicked: () -> Unit) {
    Row(modifier = Modifier
        .background(Color.Blue)
        .fillMaxWidth()
        .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Button(onClick = onXClicked) {
            Text("X")
        }
        Button(onClick = onYClicked) {
            Text("Y")
        }
    }
}

@Composable
fun ItemList(items: List<String>) {
    LazyColumn{
        items(items) { item ->
            Text(text = item, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun ResetButton(onResetClicked: () -> Unit) {
    Button(onClick = onResetClicked, modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text("Reset")
    }
}

@Preview(showBackground = true)
@Composable
fun MinAppPreview() {
    Inlamning2AndroidPia12Theme {
        MinApp()
    }
}