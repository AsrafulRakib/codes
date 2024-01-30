package com.bjit.driver.ui.screens.loginscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bjit.driver.data.remote.models.login.LoginModel
import com.bjit.driver.ui.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {
    val viewModel: LoginViewModel = hiltViewModel()
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "LOGIN")
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text(text = "Username") })
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Password") })
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                viewModel.loginRequest(
                    LoginModel(
                        password = "3ln9eAzy3nBNw4KH",
                        username = "bjit.devops"
                    )
                )
            }) {
                Text(text = "LOGIN")
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
    if (viewModel.isLoggedIn.value) {
        LaunchedEffect(Unit) {
            navController.navigate(Screen.HomeScreen.route)
        }
    }
}