package com.dynamicdriller.notificationalarmtest

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.dynamicdriller.notificationalarmtest.ui.theme.NotificationAlarmTestTheme
import com.dynamicdriller.notificationalarmtest.workmanager.setNotifications
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setNotifications("Test Instant 1", LocalDateTime.now(),applicationContext)
        setNotifications("Test Instant 2", LocalDateTime.now().plusSeconds(10),applicationContext)
        setNotifications("Test Instant 3", LocalDateTime.now().plusSeconds(20),applicationContext)
        setContent {
            NotificationAlarmTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val options = listOf("Add", "Delete", "Update")
                    BoomMenu(icon = Icons.Default.Create,  "menu", options, onOptionSelected = {"clicked"}  )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun BoomMenu(
    icon: ImageVector,
    contentDescription: String,
    options: List<String>,
    onOptionSelected: (String) -> Unit
) {
// A state variable to control the visibility of the dropdown menu
    var expanded by remember { mutableStateOf(false) }
// A state variable to store the selected option
    var selectedOption by remember { mutableStateOf("") }
// A state variable to store the animation progress
    var progress by remember { mutableStateOf(0f) }
// An animation spec to define the duration and easing of the animation
// An animation target based on the expanded state
 /*   val target = if (expanded) 1f else 0f
// Create an animation spec
    val animationSpec = FloatTweenSpec( easing = FastOutSlowInEasing, duration = 500)
// An animation that updates the progress state based on the target
    // Create a coroutine scope using the default dispatcher
    val scope = CoroutineScope(Dispatchers.Default)
// Launch a new coroutine in the scope
    scope.launch {
// Call the animate function inside the coroutine
        animate(target, animationSpec) { value, _ ->
            progress = value
        }
    }*/
// A modifier to apply some rotation and scale based on the progress state
    val modifier = Modifier.graphicsLayer {
        rotationZ = progress * 360f // rotate from 0 to 360 degrees
        scaleX = 1f + 0.5f * progress // scale from 1 to 1.5 times
        scaleY = 1f + 0.5f * progress // scale from 1 to 1.5 times
    }
// A box to contain the icon button and the dropdown menu
    Box(modifier = Modifier.wrapContentSize()) {
// An icon button that toggles the expanded state and plays a sound effect
        IconButton(
            onClick = {
                expanded = !expanded
                if (expanded) {
// Play a sound effect when expanding
//                    playSound(R.raw.boom_sound)
                } else {
// Reset the selected option when collapsing
                    selectedOption = ""
                }
            },
            modifier = modifier
        ) {
            Icon(icon, contentDescription)
        }
// A dropdown menu that shows the options with some custom layout and animation
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.graphicsLayer {
                alpha = progress // fade in/out based on the progress state
            }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedOption = option
                        onOptionSelected(option)
                        expanded = false
                    },
                    modifier = Modifier.graphicsLayer {
// Apply some offset and scale based on the option index and the progress state
                        val index = options.indexOf(option)
                        val offset = index * 50f * (1f - progress)
                        translationX = offset
                        translationY = -offset
                        scaleX = progress
                        scaleY = progress
                    }
                ) {
                    Text(option)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotificationAlarmTestTheme {
        Greeting("Android")
    }
}