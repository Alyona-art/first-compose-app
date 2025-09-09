sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Auth : Screen("auth")
}