package com.dynamicdriller.composepractice

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberImagePainter
import com.enzan.bms.ui.screens.shared.pxToDpHeight
import com.enzan.bms.ui.screens.shared.pxToDpWidth
import com.enzan.bms.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

class CustomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnzanBMSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
//                       BridgeImageSlider()
                    var openDialog by remember { mutableStateOf(true) }
                    if (openDialog) {
                        Dialog(onDismissRequest = { openDialog = false }) {
                            /*ActionDialogue(onClickButtonsvalue = {
                                Log.d("onclicktest", "onclicktest: $it")
                                if (it){
                                    Toast.makeText(this, "Action Confirmed!", Toast.LENGTH_SHORT).show()
                                }else{
                                    Toast.makeText(this, "Action Canceled!", Toast.LENGTH_SHORT).show()
                                }
                            })*/
                        }
                    } else {
                        BridgeImageSlider()
                    }


                }
            }

        }
    }
}


@Composable
fun AlertDialogueShow() {
    val context = LocalContext.current
    var openDialog by remember { mutableStateOf(true) }
    if (openDialog) {
        Dialog(onDismissRequest = { openDialog = false }) {
            ActionDialogue(onClickButtonsvalue = {
                Log.d("onclicktest", "onclicktest: $it")
                if (it) {
                    Toast.makeText(context, "Action Confirmed!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Action Canceled!", Toast.LENGTH_SHORT).show()
                }
            })
        }
    } else {
        Button(onClick = { openDialog = true }) {
            Text(text = "Click to show dialogue")
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BridgeImageSlider() {
    val indicatorsNames: List<String> = listOf("Front", "Side", "Under", "Abutment", "Pier", "Side")
    val images: List<Int> = listOf(
        R.drawable.bridge2,
        R.drawable.side,
        R.drawable.under,
        R.drawable.abutment,
        R.drawable.pier,
        R.drawable.side
    )
    var imageResource by remember { mutableStateOf(R.drawable.bridge2) }
    var selectedImageType by remember { mutableStateOf(1) }
    var alphaValue by remember { mutableStateOf(1f) }
    var backButtonalpha by remember { mutableStateOf(0f) }
    var forwardButtonalpha by remember { mutableStateOf(1f) }
    val state = rememberPagerState()
    //Top Outer Container
    Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Top) {
        Column(
            verticalArrangement = Arrangement.Top, modifier = Modifier
                .padding(8.dp)
                .width(394.dp)
                .height(344.dp)
        ) {
            //image slider part
            LaunchedEffect(selectedImageType) {
                when (selectedImageType) {
                    1 -> state.scrollToPage(0)
                    2 -> state.scrollToPage(1)
                    3 -> state.scrollToPage(2)
                    4 -> state.scrollToPage(3)
                    5 -> state.scrollToPage(4)
                    6 -> state.scrollToPage(5)
                }
            }
            Box(
                modifier = Modifier
                    .width(362.dp)
                    .height(170.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    HorizontalPager(
                        state = state,
                        count = images.size,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) { page ->
                        Log.d("pagercheck", "BridgeImageWithoutFunctions: $page")
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                when (page) {
                                    0 -> imageResource = images[0]
                                    1 -> imageResource = images[1]
                                    2 -> imageResource = images[2]
                                    3 -> imageResource = images[3]
                                    4 -> imageResource = images[4]
                                    5 -> imageResource = images[5]
                                }
                                val painter = rememberImagePainter(data = imageResource)
                                Image(
                                    painter = painter, contentDescription = "", Modifier
                                        .padding(8.dp)
                                        .animateContentSize(
                                            animationSpec = tween(
                                                delayMillis = 1000,
                                                easing = LinearOutSlowInEasing
                                            )
                                        )
                                        .fillMaxSize(), contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.width(4.dp))
                    IconButton(
                        onClick = {
                            selectedImageType--
                            when (selectedImageType) {
                                1 -> {
                                    alphaValue = 0f
                                    selectedImageType = 1
                                    backButtonalpha = 0f
                                    forwardButtonalpha = 1f
                                }
                                2 -> {
                                    alphaValue = 0f
                                    imageResource = images[0]
                                    alphaValue = 1f
                                    backButtonalpha = 1f
                                    forwardButtonalpha = 1f
                                }
                                3 -> {
                                    alphaValue = 0f
                                    imageResource = images[1]
                                    alphaValue = 1f
                                    backButtonalpha = 1f
                                    forwardButtonalpha = 1f
                                }
                                4 -> {
                                    alphaValue = 0f
                                    imageResource = images[2]
                                    alphaValue = 1f
                                    backButtonalpha = 1f
                                    forwardButtonalpha = 1f
                                }
                                5 -> {
                                    alphaValue = 0f
                                    imageResource = images[3]
                                    alphaValue = 1f
                                    backButtonalpha = 1f
                                    forwardButtonalpha = 1f
                                }
                                6 -> {
                                    alphaValue = 0f
                                    imageResource = images[4]
                                    alphaValue = 1f
                                    backButtonalpha = 1f
                                    forwardButtonalpha = 0f
                                }
                            }
                        }, modifier = Modifier
                            .height(32.dp)
                            .width(32.dp)
                            .alpha(backButtonalpha)
                            .background(Color.Gray)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = null
                        )
                    }
                    repeat(20) {
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    IconButton(
                        onClick = {
                            selectedImageType++
                            when (selectedImageType) {
                                1 -> {
                                    imageResource = R.drawable.side
                                    forwardButtonalpha = 1f
                                    backButtonalpha = 0f
                                }
                                2 -> {
                                    imageResource = R.drawable.under
                                    forwardButtonalpha = 1f
                                    backButtonalpha = 1f
                                }
                                3 -> {
                                    imageResource = R.drawable.abutment
                                    forwardButtonalpha = 1f
                                    backButtonalpha = 1f
                                }
                                4 -> {
                                    imageResource = R.drawable.pier
                                    forwardButtonalpha = 1f
                                    backButtonalpha = 1f
                                }
                                5 -> {
                                    imageResource = R.drawable.side
                                    forwardButtonalpha = 1f
                                    backButtonalpha = 1f
                                }
                                6 -> {
                                    imageResource = R.drawable.bridge2
                                    forwardButtonalpha = 0f
                                    backButtonalpha = 1f
                                }
                            }
                        }, modifier = Modifier
                            .height(32.dp)
                            .width(32.dp)
                            .alpha(forwardButtonalpha)
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
            //label
            Text(
                text = stringResource(R.string.choose_preview), modifier = Modifier
                    .width(144.dp)
                    .height(24.dp), fontSize = 19.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            //image types buttons
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(colorResource(id = R.color.gray_100))
                    .width(362.dp)
                    .height(140.dp)
            ) {
                Row {
                    val defaultModifier = Modifier
                        .height(30.dp)
                        .width(108.dp)
                        .background(color = Color.White)
                    val checkedModifier = Modifier
                        .height(30.dp)
                        .width(108.dp)
                        .background(color = Color.White)
                        .border(
                            2.dp,
                            Color.Green,
                            shape = RectangleShape
                        )
                    val defaultTextColor = Color(0, 0, 128)
                    val selectedTextColor = Color.Green
                    val fontSize = 12.sp
                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            forwardButtonalpha = 1f
                            backButtonalpha = 0f
                            selectedImageType = 1
                            imageResource = images[0]
                        }, modifier = if (state.currentPage + 1 == 1) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(
                            text = indicatorsNames[0],
                            fontSize = fontSize,
                            color = if (state.currentPage + 1 == 1) {
                                selectedTextColor
                            } else {
                                defaultTextColor
                            }
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            forwardButtonalpha = 1f
                            backButtonalpha = 1f
                            selectedImageType = 2
                            imageResource = images[1]
                        }, modifier = if (state.currentPage + 1 == 2) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(
                            text = indicatorsNames[1],
                            fontSize = fontSize,
                            color = if (state.currentPage + 1 == 2) {
                                selectedTextColor
                            } else {
                                defaultTextColor
                            }
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            forwardButtonalpha = 1f
                            backButtonalpha = 1f
                            selectedImageType = 3
                            imageResource = images[2]
                        }, modifier = if (state.currentPage + 1 == 3) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(
                            text = indicatorsNames[2],
                            fontSize = fontSize,
                            color = if (state.currentPage + 1 == 3) {
                                selectedTextColor
                            } else {
                                defaultTextColor
                            }
                        )
                    }
                }
                Row {
                    val defaultModifier = Modifier
                        .height(30.dp)
                        .width(108.dp)
                        .background(color = Color.White)
                    val checkedModifier = Modifier
                        .height(30.dp)
                        .width(108.dp)
                        .background(color = Color.White)
                        .border(
                            2.dp,
                            Color.Green,
                            shape = RectangleShape
                        )
                    val defaultTextColor = Color(0, 0, 128)
                    val selectedTextColor = Color.Green
                    val fontSize = 12.sp

                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            forwardButtonalpha = 1f
                            backButtonalpha = 1f
                            imageResource = images[3]
                            selectedImageType = 4
                        }, modifier = if (state.currentPage + 1 == 4) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(
                            text = indicatorsNames[3],
                            fontSize = fontSize,
                            color = if (state.currentPage + 1 == 4) {
                                selectedTextColor
                            } else {
                                defaultTextColor
                            }
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            forwardButtonalpha = 1f
                            backButtonalpha = 1f
                            imageResource = images[4]
                            selectedImageType = 5
                        }, modifier = if (state.currentPage + 1 == 5) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(
                            text = indicatorsNames[4],
                            fontSize = fontSize,
                            color = if (state.currentPage + 1 == 5) {
                                selectedTextColor
                            } else {
                                defaultTextColor
                            }
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            forwardButtonalpha = 0f
                            backButtonalpha = 1f
                            imageResource = images[5]
                            selectedImageType = 6
                        }, modifier = if (state.currentPage + 1 == 6) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(
                            text = indicatorsNames[5],
                            fontSize = fontSize,
                            color = if (state.currentPage + 1 == 6) {
                                selectedTextColor
                            } else {
                                defaultTextColor
                            }
                        )
                    }
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun ActionDialogue(onClickButtonsvalue: (Boolean) -> Unit) {
    val context = LocalContext.current
    //outermost box
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(336f.pxToDpWidth())
//                .height(226f.pxToDpHeight(context))
            .background(Color.White)
    ) {
        //top indicator bar
        Spacer(
            modifier = Modifier
                .width(336f.pxToDpWidth())
                .height(4f.pxToDpHeight(context))
                .background(
                    colorResource(id = R.color.error_dark)
                )
        )
        Box(
            modifier = Modifier.padding(
                24f.pxToDpWidth(),
                36f.pxToDpWidth(),
                24f.pxToDpWidth(),
                36f.pxToDpWidth()
            )
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.error_outline),
                    modifier = Modifier
                        .height(46.67f.pxToDpHeight(context))
                        .width(46.67f.pxToDpWidth()),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.action_warning_string),
                    modifier = Modifier
                        .width(264f.pxToDpWidth())
                        .height(52f.pxToDpHeight(context)),
                    style = spaceGroteskXlMedium(context),
                    textAlign = TextAlign.Center
                )
                Row(modifier = Modifier.width(264f.pxToDpWidth())) {
                    Button(
                        onClick = { onClickButtonsvalue(false) }, colors = buttonColors(
                            colorResource(
                                id = R.color.error_light
                            )
                        ),
                        modifier = Modifier
                            .width(127f.pxToDpWidth())
                            .weight(1f)
//                                    .height(40f.pxToDpHeight(context))
                            .padding(
                                horizontal = 10f.pxToDpWidth(),
                                vertical = 17f.pxToDpWidth()
                            )
                    ) {
                        Text(
                            text = stringResource(R.string.cancel_warning_string),
                            style = spaceGroteskBaseBold(context),
                            color = colorResource(
                                id = R.color.error_dark
                            )
                        )
                    }

                    Button(
                        onClick = { onClickButtonsvalue(true) }, colors = buttonColors(
                            colorResource(
                                id = R.color.error_dark
                            )
                        ), modifier = Modifier
                            .width(127f.pxToDpWidth())
                            .weight(1f)
//                                    .height(40f.pxToDpHeight(context))
                            .padding(
                                horizontal =
                                10f.pxToDpWidth(),
                                vertical =
                                17f.pxToDpWidth()
                            )
                    ) {
                        Text(
                            text = stringResource(R.string.confirm_warning_string),
                            style = spaceGroteskBaseBold(context),
                            textAlign = TextAlign.Center,
                            color = colorResource(
                                id = R.color.error_light
                            )
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EnzanBMSTheme {
        ActionDialogue(onClickButtonsvalue = {})
    }
}