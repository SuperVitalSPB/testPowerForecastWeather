package com.supervital.powerweather.navigation.route

sealed class NavRoutes(val route: String) {

    object MainScreen : NavRoutes("main_screen")

}