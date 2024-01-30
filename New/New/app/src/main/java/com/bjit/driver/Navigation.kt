package com.bjit.driver

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bjit.driver.ui.Screen
import com.bjit.driver.ui.screens.homescreen.HomeScreen
import com.bjit.driver.ui.screens.homescreen.HomeViewModel
import com.bjit.driver.ui.screens.loginscreen.LoginScreen
import com.bjit.driver.ui.screens.loginscreen.LoginViewModel
import com.bjit.driver.ui.screens.recordconstantscreen.RecordConstantScreen

@Composable
fun Navigation() {
    val loginViewModel: LoginViewModel = hiltViewModel()
    val homeViewModel : HomeViewModel = hiltViewModel()
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if (!loginViewModel.isLoggedIn.value) Screen.LoginScreen.route else Screen.HomeScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController, homeViewModel)
        }
        composable(route = Screen.RecordConstantScreen.route) {
            RecordConstantScreen(navController, homeViewModel)
        }
    }
}