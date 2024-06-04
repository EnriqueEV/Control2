package com.example.prueba2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prueba2.model.Facts
import com.example.prueba2.model.FactsQuery

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SecondScreen(
    navController: NavController,
    marsUiState: FactsQuery?,
    marsViewModel: MarsViewModel,
    modifier: Modifier = Modifier,

){
    Scaffold {
        SecondBodyContent(navController,marsUiState, modifier,marsViewModel)
    }
}
@Composable
fun SecondBodyContent(
    navController: NavController,
    marsUiState: FactsQuery?,
    modifier: Modifier,
    marsViewModel: MarsViewModel
){

    ResultScreen(
            marsUiState, modifier = modifier.fillMaxWidth(),
            navController,
            marsViewModel
        )


}




@Composable
fun ResultScreen(
    photos: FactsQuery?,
    modifier: Modifier = Modifier,
    navController: NavController,
    marsViewModel: MarsViewModel
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(top = 40.dp)) {
            Button(onClick = {navController.popBackStack()}) {
                Text("Volver")
            }

            if (photos != null) {
                if (photos.total != 0) {
                    MyMessages(messages = photos.result, marsViewModel)
                }
                else {
                    Text("No se encontraron resultados")
                }
            }
    

        }

    }

}

@Composable
fun MyMessages(messages : List<Facts>,marsViewModel: MarsViewModel){
    LazyColumn {
        items(messages) {message -> MyComponent(message = message,marsViewModel)}
    }
}
@Composable
fun MyComponent(message : Facts,marsViewModel: MarsViewModel){
    Row(modifier = Modifier.padding(8.dp)){
        Column {
            Text(message.value)
            Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Red),onClick = { marsViewModel.addText(message.value) }){
                Text(text = "like")
            }

        }
    }
}