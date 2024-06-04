package com.example.prueba2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prueba2.model.Facts

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ThirdScreen(navController: NavController, fav : List<String>){
    Scaffold {

        ThirdBodyContent(navController,fav)
    }
}
@Composable
fun ThirdBodyContent(navController: NavController, fav: List<String>){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        //ApiResponseScreen()
        Button(onClick = {navController.popBackStack() }) {
            Text("Volver")
        }
        My3Messages(messages = fav)
    }
}

@Composable
fun My3Messages(messages : List<String>){
    LazyColumn {
        items(messages) {message -> My3Component(message = message)}
    }
}
@Composable
fun My3Component(message : String){
    Row(modifier = Modifier.padding(8.dp)){
        Column {
            Text(message)
        }
    }
}