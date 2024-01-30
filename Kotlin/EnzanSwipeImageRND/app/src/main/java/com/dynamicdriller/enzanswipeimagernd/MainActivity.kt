package com.dynamicdriller.enzanswipeimagernd

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynamicdriller.enzanswipeimagernd.ui.theme.EnzanSwipeImageRNDTheme
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnzanSwipeImageRNDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BridgeImageGallery()
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun BridgeImageGallery() {
    var imageResource by remember { mutableStateOf(R.drawable.bridge2) }
    var selectedImageType by remember { mutableStateOf(1) }
    var alphaValue by remember { mutableStateOf(1f) }
    Column(verticalArrangement = Arrangement.Top, modifier = Modifier.padding(20.dp)) {
        //image part
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentAlignment = Alignment.Center
        ) {
            val back = SwipeAction(
                icon = painterResource(R.drawable.back),
                background = Color.Gray,
                isUndo = true,
                onSwipe = { when (selectedImageType) {
                    1 -> {
                        selectedImageType = 6
                        imageResource = R.drawable.side
                    }
                    2 -> {
                        selectedImageType--
                        imageResource = R.drawable.bridge2
                    }
                    3 -> {
                        selectedImageType--
                        imageResource = R.drawable.side
                    }
                    4 -> {
                        selectedImageType--
                        imageResource = R.drawable.under
                    }
                    5 -> {
                        selectedImageType--
                        imageResource = R.drawable.abutment
                    }
                    6 -> {
                        selectedImageType--
                        imageResource = R.drawable.pier
                    }
                }}
            )

            // Creating a Swipe Action for Sending a message;
            // setting icon, background and what happens when swiped
            val forward = SwipeAction(
                icon = painterResource(R.drawable.forward),
                background = Color.Gray,
                isUndo = true,
                onSwipe = {   when (selectedImageType) {
                    1 -> {
                        selectedImageType++
                        imageResource = R.drawable.side
                    }
                    2 -> {
                        selectedImageType++
                        imageResource = R.drawable.under
                    }
                    3 -> {
                        selectedImageType++
                        imageResource = R.drawable.abutment
                    }
                    4 -> {
                        selectedImageType++
                        imageResource = R.drawable.pier
                    }
                    5 -> {
                        selectedImageType++
                        imageResource = R.drawable.side
                    }
                    6 -> {
                        selectedImageType = 1
                        imageResource = R.drawable.bridge2
                    }
                } }
            )
            SwipeableActionsBox(startActions = listOf(back), endActions = listOf(forward)) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(alphaValue)
                        .animateContentSize(),
                    contentDescription = null
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.width(4.dp))
                IconButton(
                    onClick = {

                        when (selectedImageType) {
                            1 -> {
                                alphaValue = 0f
                                selectedImageType = 6
                                imageResource = R.drawable.side
                                alphaValue = 0.5f
                                alphaValue = 1f
                            }
                            2 -> {
                                alphaValue = 0f
                                selectedImageType--
                                imageResource = R.drawable.bridge2
                                alphaValue = 0.5f
                                alphaValue = 1f
                            }
                            3 -> {
                                alphaValue = 0f
                                selectedImageType--
                                imageResource = R.drawable.side
                                alphaValue = 0.5f
                                alphaValue = 1f
                            }
                            4 -> {
                                alphaValue = 0f
                                selectedImageType--
                                imageResource = R.drawable.under
                                alphaValue = 0.5f
                                alphaValue = 1f
                            }
                            5 -> {
                                alphaValue = 0f
                                selectedImageType--
                                imageResource = R.drawable.abutment
                                alphaValue = 0.5f
                                alphaValue = 1f
                            }
                            6 -> {
                                alphaValue = 0f
                                selectedImageType--
                                imageResource = R.drawable.pier
                                alphaValue = 0.5f
                                alphaValue = 1f
                            }
                        }
                    }, modifier = Modifier
                        .height(40.dp)
                        .width(50.dp)
                        .background(Color.Gray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null
                    )
                }
                repeat(20){
                    Spacer(modifier = Modifier.width(5.dp))
                }
                IconButton(
                    onClick = {
                        when (selectedImageType) {
                            1 -> {
                                selectedImageType++
                                imageResource = R.drawable.side
                            }
                            2 -> {
                                selectedImageType++
                                imageResource = R.drawable.under
                            }
                            3 -> {
                                selectedImageType++
                                imageResource = R.drawable.abutment
                            }
                            4 -> {
                                selectedImageType++
                                imageResource = R.drawable.pier
                            }
                            5 -> {
                                selectedImageType++
                                imageResource = R.drawable.side
                            }
                            6 -> {
                                selectedImageType = 1
                                imageResource = R.drawable.bridge2
                            }
                        }
                    }, modifier = Modifier
                        .height(40.dp)
                        .width(50.dp)
                        .background(Color.Gray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.forward),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
        //image types
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = CenterHorizontally
        ) {
            Row(modifier = Modifier.padding(6.dp)) {
                val defaultModifier = Modifier
                    .height(60.dp)
                    .background(color = Color.White)
                    .weight(1f)

                val checkedModifier = Modifier
                    .height(60.dp)
                    .background(color = Color.White)
                    .weight(1f)
                    .border(2.dp, colorResource(id = R.color.dark_green), shape = RectangleShape)
                val defaultTextColor =  Color(0, 0, 128)
                val selectedTextColor =   colorResource(id = R.color.dark_green)
                TextButton(
                    shape = RectangleShape,
                    onClick = {
                        imageResource = R.drawable.bridge2
                        selectedImageType = 1
                    }, modifier = if (selectedImageType ==1) {
                        checkedModifier
                    } else {
                        defaultModifier
                    }
                ) {
                    Text(text = "Front", fontSize = 40.sp, color = if (selectedImageType == 1){
                        selectedTextColor
                    }else{
                        defaultTextColor
                    })
                }
                Spacer(modifier = Modifier.width(6.dp))
                TextButton(
                    shape = RectangleShape,
                    onClick = {
                        imageResource = R.drawable.side
                        selectedImageType = 2
                    },  modifier = if (selectedImageType ==2) {
                        checkedModifier
                    } else {
                        defaultModifier
                    }
                ) {
                    Text(text = "Side", fontSize = 40.sp, color = if (selectedImageType == 2){
                        selectedTextColor
                    }else{
                        defaultTextColor
                    })
                }
                Spacer(modifier = Modifier.width(6.dp))
                TextButton(
                    shape = RectangleShape,
                    onClick = {
                        imageResource = R.drawable.under
                        selectedImageType = 3
                    },  modifier = if (selectedImageType ==3) {
                        checkedModifier
                    } else {
                        defaultModifier
                    }
                ) {
                    Text(text = "Under", fontSize = 40.sp,color = if (selectedImageType == 3){
                        selectedTextColor
                    }else{
                        defaultTextColor
                    })
                }
            }
            Row(modifier = Modifier.padding(6.dp)) {
                val defaultModifier = Modifier
                    .height(60.dp)
                    .background(color = Color.White)
                    .weight(1f)

                val checkedModifier = Modifier
                    .height(60.dp)
                    .background(color = Color.White)
                    .weight(1f)
                    .border(2.dp, colorResource(id = R.color.dark_green), shape = RectangleShape)

                val defaultTextColor =  Color(0, 0, 128)
                val selectedTextColor =   colorResource(id = R.color.dark_green)

                TextButton(
                    shape = RectangleShape,
                    onClick = {
                        imageResource = R.drawable.abutment
                        selectedImageType = 4
                    },  modifier = if (selectedImageType ==4) {
                        checkedModifier
                    } else {
                        defaultModifier
                    }
                ) {
                    Text(text = "Abutment", fontSize = 40.sp, color = if (selectedImageType == 4){
                        selectedTextColor
                    }else{
                        defaultTextColor
                    })
                }
                Spacer(modifier = Modifier.width(6.dp))
                TextButton(
                    shape = RectangleShape,
                    onClick = {
                        imageResource = R.drawable.pier
                        selectedImageType = 5
                    },  modifier = if (selectedImageType ==5) {
                        checkedModifier
                    } else {
                        defaultModifier
                    }
                ) {
                    Text(text = "Pier", fontSize = 40.sp, color = if (selectedImageType == 5){
                        selectedTextColor
                    }else{
                        defaultTextColor
                    })
                }
                Spacer(modifier = Modifier.width(6.dp))
                TextButton(
                    shape = RectangleShape,
                    onClick = {
                        imageResource = R.drawable.side
                        selectedImageType = 6
                    },  modifier = if (selectedImageType ==6) {
                        checkedModifier
                    } else {
                        defaultModifier
                    }
                ) {
                    Text(text = "Side", fontSize = 40.sp, color = if (selectedImageType == 6){
                        selectedTextColor
                    }else{
                        defaultTextColor
                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EnzanSwipeImageRNDTheme {
        BridgeImageGallery()
    }
}