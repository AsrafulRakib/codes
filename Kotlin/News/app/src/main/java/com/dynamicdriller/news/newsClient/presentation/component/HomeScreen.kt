package com.dynamicdriller.news.newsClient.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Surface( modifier = Modifier.fillMaxSize()) {
        // Your Home Screen UI
        Text(text = "Home", modifier = Modifier.fillMaxSize(), fontSize = 50.sp)
    }
}