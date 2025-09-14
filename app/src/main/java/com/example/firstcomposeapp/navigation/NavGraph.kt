package com.example.firstcomposeapp.navigation

import AuthScreen
import SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

@Composable
fun AppNavigation() {
    val backStack = remember { mutableStateListOf<Screen>(Screen.Splash) }

    NavDisplay(backStack = backStack, onNavigate = { screen ->
        backStack.add(screen)
    })
}

@Composable
fun NavDisplay(backStack: List<Screen>, onNavigate: (Screen) -> Unit) {
    val currentScreen = backStack.last()

    when (currentScreen) {
        is Screen.Splash -> SplashScreen(onSplashFinished = {
            onNavigate(Screen.Auth)
        })

        is Screen.Auth -> AuthScreen()
    }
}
