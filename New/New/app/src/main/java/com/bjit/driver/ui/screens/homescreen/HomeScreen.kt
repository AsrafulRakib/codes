package com.bjit.driver.ui.screens.homescreen

import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bjit.driver.ui.Screen
import com.bjit.driver.ui.screens.loginscreen.LoginViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
//    Text(text = "Hello World!")
CameraScreen()
//    val loginViewModel: LoginViewModel = hiltViewModel()
//    Scaffold(modifier = modifier,
//        topBar = { TopBar(loginViewModel, navController) },
//        floatingActionButton = { DriverFloatingActionButton(navController, homeViewModel) }) {
//        Box(modifier = modifier.padding(it)) {
//            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//                Button(onClick = { homeViewModel.testImageTestPost() }) {
//                    Text(text = "IMAGETEST POST TEST BUTTON")
//                }
//                if (homeViewModel.listOfRecords.value.isEmpty()) {
//                    Text(text = "No records to show, please add a record")
//                } else {
//                    homeViewModel.listOfRecords.value.forEach { record ->
//                        Text(
//                            text = record.data?.driverPureImageDetails?.image ?: "RECORD",
//                            modifier = Modifier.clickable {
//                                homeViewModel.setCurrentRecord(record)
//                                navController.navigate(Screen.RecordConstantScreen.route)
//                            })
//                    }
//                }
//            }
//        }
//    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(loginViewModel: LoginViewModel, navController: NavController) {
    TopAppBar(title = { Text("DRIVER Home Screen") }, actions = {
        IconButton(onClick = {
            loginViewModel.logout()
            navController.navigate(Screen.LoginScreen.route)
        }) {
            Row {
                Icon(Icons.Default.ArrowLeft, "Logout Button")
                Text(text = "LOGOUT")
            }
        }
    })
}

@Composable
fun DriverFloatingActionButton(navController: NavController, homeViewModel: HomeViewModel) {
//    FloatingActionButton(onClick = {
//        navController.navigate(Screen.RecordConstantScreen.route)
//        homeViewModel.createNewRecord()
//    }) {
//        Icon(Icons.Default.Add, contentDescription = "Add a Record")
//    }
}