package com.example.prueba2.navigation

sealed class AppScreens(val route: String){
    object FirstScreen: AppScreens(route = "first_screen")
    object SecondScreen: AppScreens(route = "second_screen/{text}")
    object ThirdScreen: AppScreens(route = "third_screen")
}