package com.bjit.driver.ui

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")
    object RecordConstantScreen : Screen("record_constant_screen")
}