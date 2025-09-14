package com.example.firstcomposeapp.navigation

sealed class Screen {
    object Splash : Screen()
    object Auth : Screen()
}
