package com.dynamicdriller.imageslider

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.dynamicdriller.imageslider.ui.theme.ImageSliderTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageSliderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
//                    BridgeImageSlider()
                    SpeedometerProgressbar(500.dp,90f, Modifier, 8.dp)
                }
            }
        }
    }
}


@Composable
fun MeterImage() {
    // Define the list of colors and the color stops for the gradient
    val colors = listOf(Color.Blue, Color.Green, Color.Yellow, Color.Magenta, Color.Red)

// Create a Brush object with the desired gradient type and direction
    val brush = Brush.horizontalGradient(colors)
// Create a Canvas composable to draw the image with custom shapes and colors
    Canvas(modifier = Modifier.size(500.dp).padding(80.dp)) {
// Draw a gray arc with a stroke
        drawArc(
           brush = brush,
            startAngle = -180f,
            sweepAngle = 180f,
            useCenter = false,
            style = Stroke(width = 50.dp.toPx())
        )

// Draw tick marks along the arc
  /*      val radius = size.width / 2
        val tickAngles = listOf(135f, 180f, 225f)
        for (angle in tickAngles) {
            val cos = cos(angle * PI / 180).toFloat()
            val sin = sin(angle * PI / 180).toFloat()
            val innerX = radius + (radius - 20.dp.toPx()) * cos
            val innerY = radius + (radius - 20.dp.toPx()) * sin
            val outerX = radius + radius * cos
            val outerY = radius + radius * sin
            drawLine(
                color = Color.Black,
                start = Offset(innerX, innerY),
                end = Offset(outerX, outerY),
                strokeWidth = 4.dp.toPx()
            )
        }*/

// Draw a pointer at the desired value
        val radius = size.width / 2
        val angle = -90f
        val cos = cos(angle * PI / 180).toFloat()
        val sin = sin(angle * PI / 180).toFloat()
        val innerX = radius + (radius - 20.dp.toPx()) * cos
        val innerY = radius + (radius - 20.dp.toPx()) * sin
        val outerX = radius + radius * cos
        val outerY = radius + radius * sin
        drawLine(
            color = Color.Black,
            start = Offset(innerX, innerY),
            end = Offset(outerX, outerY),
            strokeWidth = 10.dp.toPx(),
            blendMode = BlendMode.ColorDodge
        )
    }

}




/*@Composable
fun BridgeListItem(){
    val content = LocalContext.current
    Surface() {
        Row(modifier = Modifier
            .width(456f.pxTo)
            .height(292.dp)) {
            Column(modifier = Modifier
                .width(200.dp)
                .height(250.dp)) {
                Image(painter = painterResource(id = R.drawable.bridge2), modifier = Modifier.fillMaxSize(), contentDescription = null, contentScale = ContentScale.FillBounds)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = stringResource(R.string.location), modifier = Modifier
                    .width(72.dp)
                    .height(20.dp), fontSize = 16.sp, color = colorResource(id = R.color.grey_500))
                Text(text = stringResource(R.string.photo_abdument1), modifier = Modifier
                    .width(296.dp)
                    .height(32.dp), fontSize = 16.sp, color = Color.Black)
            }
        }
    }
}*/

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BridgeImageSlider(){
    val indicatorsNames :List<String> = listOf("Front", "Side", "Under", "Abutment", "Pier", "Side")
    val  images :List<Int>  = listOf(R.drawable.bridge2,
        R.drawable.side,
        R.drawable.under,
        R.drawable.abutment,
        R.drawable.pier,
        R.drawable.side)
    var imageResource by remember { mutableStateOf(R.drawable.bridge2) }
    var selectedImageType by remember { mutableStateOf(1) }
    var alphaValue by remember { mutableStateOf(1f) }
    var backButtonalpha by remember { mutableStateOf(0f) }
    var forwardButtonalpha by remember { mutableStateOf(1f) }
    val state = rememberPagerState()
    //Top Outer Container
    Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Top) {
        Column(verticalArrangement = Arrangement.Top,modifier = Modifier
            .padding(8.dp)
            .width(394.dp)
            .height(344.dp)) {
            //image slider part
            LaunchedEffect(selectedImageType) {
                when(selectedImageType){
                    1->state.scrollToPage(0)
                    2->state.scrollToPage(1)
                    3->state.scrollToPage(2)
                    4->state.scrollToPage(3)
                    5->state.scrollToPage(4)
                    6->state.scrollToPage(5)
                }
            }
            Box( modifier = Modifier
                .width(362.dp)
                .height(170.dp),
                contentAlignment = Alignment.Center) {
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
                                when(page){
                                    0-> imageResource = images[0]
                                    1-> imageResource = images[1]
                                    2-> imageResource = images[2]
                                    3-> imageResource = images[3]
                                    4-> imageResource = images[4]
                                    5-> imageResource = images[5]
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
                    repeat(20){
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    IconButton(
                        onClick = {  selectedImageType++
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
            Text(text = stringResource(R.string.choose_preview_label), modifier = Modifier
                .width(144.dp)
                .height(24.dp), fontSize = 19.sp)
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
                    var color by remember { mutableStateOf(Color.Black) }
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
                            colorResource(id = R.color.dark_green),
                            shape = RectangleShape
                        )
                    val defaultTextColor =  Color(0, 0, 128)
                    val selectedTextColor =   colorResource(id = R.color.dark_green)
                    val fontSize = 12.sp
                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            selectedImageType = 1
                            imageResource = images[0]
                        },  modifier = if (state.currentPage+1 ==1) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(text = indicatorsNames[0], fontSize = fontSize, color = if (state.currentPage+1== 1){
                            selectedTextColor
                        }else{
                            defaultTextColor
                        })
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            selectedImageType = 2
                            imageResource = images[1]
                        },  modifier = if (state.currentPage+1 ==2) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(text = indicatorsNames[1], fontSize = fontSize, color = if (state.currentPage+1 == 2){
                            selectedTextColor
                        }else{
                            defaultTextColor
                        })
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            selectedImageType = 3
                            imageResource = images[2]
                        },  modifier = if (state.currentPage+1 ==3) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(text = indicatorsNames[2], fontSize = fontSize, color = if (state.currentPage+1 == 3){
                            selectedTextColor
                        }else{
                            defaultTextColor
                        })
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
                            colorResource(id = R.color.dark_green),
                            shape = RectangleShape
                        )
                    val defaultTextColor =  Color(0, 0, 128)
                    val selectedTextColor =   colorResource(id = R.color.dark_green)
                    val fontSize = 12.sp

                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            imageResource = images[3]
                            selectedImageType = 4
                        },  modifier = if (state.currentPage+1 ==4) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(text = indicatorsNames[3], fontSize = fontSize, color = if (state.currentPage+1 == 4){
                            selectedTextColor
                        }else{
                            defaultTextColor
                        })
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            imageResource = images[4]
                            selectedImageType = 5
                        },  modifier = if (state.currentPage+1 ==5) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(text = indicatorsNames[4], fontSize = fontSize, color = if (state.currentPage+1 == 5){
                            selectedTextColor
                        }else{
                            defaultTextColor
                        })
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    TextButton(
                        shape = RectangleShape,
                        onClick = {
                            imageResource = images[5]
                            selectedImageType = 6
                        },  modifier = if (state.currentPage+1 ==6) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(text = indicatorsNames[5], fontSize = fontSize, color = if (state.currentPage+1 == 6){
                            selectedTextColor
                        }else{
                            defaultTextColor
                        })
                    }
                }
            }
        }
    }
}




@Composable
fun DefaultPreview() {
    ImageSliderTheme {
        BridgeImageSlider()
    }
}