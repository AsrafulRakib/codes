package com.dynamicdriller.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dynamicdriller.news.newsClient.presentation.component.BookMarkScreen
import com.dynamicdriller.news.newsClient.presentation.component.HomeScreen
import com.dynamicdriller.news.newsClient.presentation.component.SettingsScreen

@Composable
fun MainScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(1f)) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen() }
            composable("bookmark") { BookMarkScreen() }
            composable("settings") { SettingsScreen() }
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Divider() // Optional divider line
            BottomNavigationBar(navController)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    var (selectedNavItem, setSelectedNavItem) = remember { mutableStateOf("home") }
    val items = listOf(
        NavigationItem("Home", Icons.Filled.Home, "home"),
        NavigationItem("BookMark", Icons.Filled.FavoriteBorder, "bookmark"),
        NavigationItem("Settings", Icons.Filled.Settings, "settings")
    )
    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 8.dp
    ) {

        val navBackStackEntry = navController.currentBackStackEntry
        val currentDestination = navBackStackEntry?.destination
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.title) },
                selected = selectedNavItem == item.route,
                onClick = {
                    selectedNavItem = item.route
                    setSelectedNavItem(item.route)
                    navController.navigate(item.route) {
                      /*  launchSingleTop = true*/
                        restoreState = true
                    }
                }
            )
        }
    }
}
data class NavigationItem(val title: String, val icon: ImageVector, val route: String)
