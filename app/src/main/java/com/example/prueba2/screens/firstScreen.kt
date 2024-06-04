package com.example.prueba2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prueba2.navigation.AppNavigation
//import com.example.prueba2.api.ApiResponseScreen
import com.example.prueba2.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstScreen(navController: NavController){
    Scaffold {
        BodyContent(navController)
    }
}
@Composable
fun BodyContent(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TextField(value = text,
            onValueChange = { text = it },
            label = { Text("Facts a buscar") })
        //ApiResponseScreen()
        Button(onClick = { navController.navigate("second_screen/$text") }) {
            Text("Buscar")
        }
        Button(onClick = { navController.navigate(AppScreens.ThirdScreen.route) }) {
            Text("Favoritos")
        }
    }
}
