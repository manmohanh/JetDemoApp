package com.mhansda.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mhansda.demoapp.ui.theme.DemoAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    DemoContent()
                }
            }
        }
    }
}
@Composable
fun DemoContent(){
    Column(modifier = Modifier.padding(16.dp)) {

        var nameState by remember {
            mutableStateOf(" ")
        }
        if(nameState.isNotEmpty()){
            Text(
                text = "Hello,$nameState!",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp)
            )
        }
        OutlinedTextField(
            value = nameState,
            onValueChange = { nameState = it },
            label = { Text(text = "Name") }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoAppTheme {
        DemoContent()
    }
}