package com.example.prueba2.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.prueba2.screens.FirstScreen
import com.example.prueba2.screens.MarsViewModel
import com.example.prueba2.screens.SecondScreen
import com.example.prueba2.screens.ThirdScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    val marsViewModel: MarsViewModel = viewModel()

    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route) {
        composable(route = AppScreens.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(route = AppScreens.SecondScreen.route,
            arguments = listOf(navArgument("text") { type = NavType.StringType })) { backStackEntry ->
            val text = backStackEntry.arguments?.getString("text") ?: ""
            marsViewModel.fetchJokes(text)
            SecondScreen(navController, marsUiState = marsViewModel.factsQueryResult,marsViewModel)
        }
        composable(route = AppScreens.ThirdScreen.route){
            ThirdScreen(navController = navController, fav =marsViewModel.getTextList() )
        }
    }
}