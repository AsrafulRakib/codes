package com.dynamicdriller.composepractice

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dynamicdriller.composepractice.ui.theme.ComposePracticeTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import coil.compose.rememberImagePainter

const val passkey = "123"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            /*val navController = rememberNavController()
            NavHost(navController, startDestination = "login") {
                composable("login") { LoginScreen(navController) }
                composable("welcome") {
                    when (LocalConfiguration.current.orientation) {
                        Configuration.ORIENTATION_LANDSCAPE -> WelcomeScreenLand(navController)
                        Configuration.ORIENTATION_PORTRAIT -> WelcomeScreen(navController)
                    }
                }
            }*/
            BridgeImageGallery()
            /* Row(
                 horizontalArrangement = Arrangement.Center,
                 verticalAlignment = Alignment.CenterVertically,
                 modifier = Modifier.fillMaxSize()
             ) {
                 Column(
                     horizontalAlignment = Alignment.CenterHorizontally,
                     verticalArrangement = Arrangement.Center
                 ) {
                     Spacer(modifier = Modifier.height(40.dp))
                     var password by remember { mutableStateOf("") }
                     TextField(
                         value = password,
                         onValueChange = { password += it },
                         placeholder = { Text("Enter Password", fontSize = 40.sp) },
                         visualTransformation = PasswordVisualTransformation(),
                         keyboardOptions = KeyboardOptions(
                             keyboardType = KeyboardType.NumberPassword
                         ),
                         modifier = Modifier
                             .padding(horizontal = 16.dp)
                             .fillMaxWidth(0.6F)
                     )
                     Spacer(modifier = Modifier.height(10.dp))
                     KeyPad(onUpdate = {
                         if (it == ""){
                             password = ""
                         }
                         if (it == "ok"){
                             if (password=="123"){
                                 Log.d("Login", "check login: entered ")
                             }
                         }
                         else{
                             password += it
                         }
                     })
                 }
             }*/
        }
    }
}

@Composable
fun BridgeListItem(){
    val content = LocalContext.current
    Surface() {
        Row(modifier = Modifier
            .width(456f.dp)
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
}


@Composable
fun KeyPad(onUpdate: (String) -> Unit) {
    Column(verticalArrangement = Arrangement.Top) {
        Row(modifier = Modifier.padding(6.dp)) {
            TextButton(
                onClick = {
                    onUpdate("1")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Text(text = "1", fontSize = 40.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.width(6.dp))
            TextButton(
                onClick = {
                    onUpdate("2")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Text(text = "2", fontSize = 40.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.width(6.dp))
            TextButton(
                onClick = {
                    onUpdate("3")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Text(text = "3", fontSize = 40.sp, color = Color.Black)
            }
        }
        Row(modifier = Modifier.padding(6.dp)) {
            TextButton(
                onClick = {
                    onUpdate("4")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Text(text = "4", fontSize = 40.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.width(6.dp))
            TextButton(
                onClick = {
                    onUpdate("5")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Text(text = "5", fontSize = 40.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.width(6.dp))
            TextButton(
                onClick = {
                    onUpdate("6")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Text(text = "6", fontSize = 40.sp, color = Color.Black)
            }
        }
        Row(modifier = Modifier.padding(6.dp)) {
            TextButton(
                onClick = {
                    onUpdate("7")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Text(text = "7", fontSize = 40.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.width(6.dp))
            TextButton(
                onClick = {
                    onUpdate("8")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Text(text = "8", fontSize = 40.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.width(6.dp))
            TextButton(
                onClick = {
                    onUpdate("9")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Text(text = "9", fontSize = 40.sp, color = Color.Black)
            }
        }
        Row(
            modifier = Modifier.padding(6.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            val image1 = Icons.Filled.Close
            val image2 = Icons.Filled.Check
            TextButton(
                onClick = {
                    onUpdate("")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Image(
                    imageVector = image1,
                    colorFilter = ColorFilter.tint(Color.Red),
                    contentDescription = "Clear",
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                )
            }
            Spacer(modifier = Modifier.width(6.dp))
            TextButton(
                onClick = {
                    onUpdate("0")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Text(text = "0", fontSize = 40.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.width(6.dp))
            TextButton(
                onClick = {
                    onUpdate("ok")
                }, modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .border(4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .width(100.dp)
            ) {
                Image(
                    imageVector = image2,
                    colorFilter = ColorFilter.tint(Color.Green),
                    contentDescription = "Clear",
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                )
            }
        }
    }
}

@Composable
fun ResponsiveText(text: String) {
    val configuration = LocalConfiguration.current
    val fontScale = configuration.fontScale
    val screenWidthDp = configuration.screenWidthDp.dp
    val fontSize = with(LocalDensity.current) { screenWidthDp / 40 }
    val finalsize = fontSize * fontScale
    Text(
        text = text,
        fontSize = LocalDensity.current.run { finalsize.toSp() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                var password by remember { mutableStateOf("") }
                TextField(
                    value = password,
                    onValueChange = { password += it },
                    placeholder = { Text("Enter Password", fontSize = 40.sp) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(0.6F)
                )
                Spacer(modifier = Modifier.height(10.dp))
                KeyPad(onUpdate = {
                    if (it == "") {
                        password = ""
                    }
                    if (it == "ok") {
                        if (password == passkey) {
                            Log.d("Login", "check login: entered ")
                            navController.navigate("welcome")
                        }
                    } else {
                        password += it
                    }
                })
            }
        }
    }
}

@Composable
fun WelcomeScreenLand(navController: NavController) {
    Row(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.weight(2f)) {
            /* Image(painter = painterResource(id = R.drawable.baseline_settings_24), contentDescription = null)*/
            Text(text = "Enzan", fontSize = 40.sp)
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier
                .weight(5f)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Box(contentAlignment = Alignment.TopStart) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(verticalAlignment = CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Card(
                            modifier = Modifier
                                .weight(2f)
                                .height(100.dp),
                            backgroundColor = Color.LightGray
                        ) {
                            Column(verticalArrangement = Arrangement.SpaceEvenly) {
                                ResponsiveText("Edit Inventory")
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_settings_24),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Card(
                            modifier = Modifier
                                .weight(4f)
                                .align(CenterVertically)
                                .fillMaxWidth()
                                .height(100.dp),
                            backgroundColor = colorResource(id = R.color.light_green)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = CenterHorizontally,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                /*Text(text = "AAAA Bridge", fontSize = 20.sp, modifier = Modifier
                                    .padding(5.dp))*/
                                ResponsiveText("AAAA Bridge")
                            }
                        }
                        Column(
                            modifier = Modifier
                                .weight(3f)
                                .height(100.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(100.dp),
                                backgroundColor = colorResource(id = R.color.lime_green)
                            ) {
                                /* Text(text = "Last Inspection Date", fontSize = 20.sp, modifier = Modifier
                                     .padding(5.dp))*/
                                ResponsiveText("Last Inspection Date")
                            }
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(100.dp)
                            ) {
                                /*Text(text = "2023/01/06", fontSize = 20.sp, modifier = Modifier
                                    .padding(5.dp))*/
                                ResponsiveText("2023/01/06")
                            }
                        }
                        //start inspection
                        Column(
                            modifier = Modifier
                                .weight(3f)
                                .height(IntrinsicSize.Min)
                        ) {
                            Card(
                                modifier = Modifier
                                    .weight(3f)
                                    .height(IntrinsicSize.Min)
                            ) {
                                /* Text(text = "Start Inspection", fontSize = 20.sp, modifier = Modifier
                                     .padding(5.dp))*/
                                ResponsiveText("Start Inspection")
                            }
                            Card(
                                modifier = Modifier
                                    .weight(5f)
                                    .height(100.dp)
                                    .fillMaxWidth()
                            ) {
                                val image = painterResource(id = R.drawable.edit_note)
                                OutlinedButton(
                                    onClick = {}, modifier = Modifier
                                        .padding(5.dp)
                                ) {
                                    Image(
                                        painter = image,
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            //sides image
            Row(
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                ) {
                    Text(
                        text = "Front",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.edit_note),
                        contentDescription = null,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                ) {
                    Text(
                        text = "Side",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.edit_note),
                        contentDescription = null,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                ) {
                    Text(
                        text = "Under",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.edit_note),
                        contentDescription = null,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                ) {
                    Text(
                        text = "Abutmen",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.edit_note),
                        contentDescription = null,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Pier",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                            .padding(10.dp)
                            .align(alignment = CenterHorizontally)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.edit_note),
                        contentDescription = null,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                        .height(80.dp), shape = RoundedCornerShape(8.dp),
                    backgroundColor = colorResource(id = R.color.light_green)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("Zone")
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier = Modifier
                        .weight(2f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                        .height(80.dp), shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("Central Punjab")
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .height(80.dp), shape = RoundedCornerShape(8.dp),
                    backgroundColor = colorResource(id = R.color.light_green)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("District")
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier = Modifier
                        .weight(2f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .height(80.dp), shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("Kasur")
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                        .height(80.dp), shape = RoundedCornerShape(8.dp),
                    backgroundColor = colorResource(id = R.color.light_green)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("Road Name")
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier = Modifier
                        .weight(3f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                        .height(80.dp), shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("Pattoki to Raiwind Road")
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                        .height(80.dp), shape = RoundedCornerShape(8.dp),
                    backgroundColor = colorResource(id = R.color.light_green)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("Bridge Name")
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier = Modifier
                        .weight(3f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                        .height(80.dp), shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("Pattoki to Raiwind Road")
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                        .height(80.dp), shape = RoundedCornerShape(8.dp),
                    backgroundColor = colorResource(id = R.color.light_green)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("Structure Type")
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                        .height(80.dp), shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("Bridge")
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                        .height(80.dp), shape = RoundedCornerShape(8.dp),
                    backgroundColor = colorResource(id = R.color.light_green)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("Construction year")
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .align(CenterVertically)
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                        .height(80.dp), shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ResponsiveText("2021/01")
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                TextButton(
                    onClick = { navController.navigate("login") }, modifier = Modifier.background(
                        colorResource(R.color.light_green)
                    )
                ) {
                    Text(text = "Back", color = Color.Black, fontSize = 40.sp)
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Box(contentAlignment = Alignment.TopStart) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row(verticalAlignment = CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier
                            .weight(2f)
                            .height(100.dp),
                        backgroundColor = Color.LightGray
                    ) {
                        Column(verticalArrangement = Arrangement.SpaceEvenly) {
                            ResponsiveText("Edit Inventory")
                            Image(
                                painter = painterResource(id = R.drawable.baseline_settings_24),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Card(
                        modifier = Modifier
                            .weight(4f)
                            .align(CenterVertically)
                            .fillMaxWidth()
                            .height(100.dp),
                        backgroundColor = colorResource(id = R.color.light_green)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            /*Text(text = "AAAA Bridge", fontSize = 20.sp, modifier = Modifier
                                .padding(5.dp))*/
                            ResponsiveText("AAAA Bridge")
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(3f)
                            .height(100.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .height(100.dp),
                            backgroundColor = colorResource(id = R.color.lime_green)
                        ) {
                            /* Text(text = "Last Inspection Date", fontSize = 20.sp, modifier = Modifier
                                 .padding(5.dp))*/
                            ResponsiveText("Last Inspection Date")
                        }
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .height(100.dp)
                        ) {
                            /*Text(text = "2023/01/06", fontSize = 20.sp, modifier = Modifier
                                .padding(5.dp))*/
                            ResponsiveText("2023/01/06")
                        }
                    }
                    //start inspection
                    Column(
                        modifier = Modifier
                            .weight(3f)
                            .height(IntrinsicSize.Min)
                    ) {
                        Card(
                            modifier = Modifier
                                .weight(3f)
                                .height(IntrinsicSize.Min)
                        ) {
                            /* Text(text = "Start Inspection", fontSize = 20.sp, modifier = Modifier
                                 .padding(5.dp))*/
                            ResponsiveText("Start Inspection")
                        }
                        Card(
                            modifier = Modifier
                                .weight(5f)
                                .height(100.dp)
                                .fillMaxWidth()
                        ) {
                            val image = painterResource(id = R.drawable.edit_note)
                            OutlinedButton(
                                onClick = {}, modifier = Modifier
                                    .padding(5.dp)
                            ) {
                                Image(
                                    painter = image,
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        //sides image
        Row(
            verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text(
                    text = "Front",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                        .padding(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.edit_note),
                    contentDescription = null,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text(
                    text = "Side",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                        .padding(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.edit_note),
                    contentDescription = null,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text(
                    text = "Under",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                        .padding(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.edit_note),
                    contentDescription = null,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text(
                    text = "Abutmen",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                        .padding(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.edit_note),
                    contentDescription = null,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Pier",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                        .padding(10.dp)
                        .align(alignment = CenterHorizontally)
                )
                Image(
                    painter = painterResource(id = R.drawable.edit_note),
                    contentDescription = null,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .height(80.dp), shape = RoundedCornerShape(8.dp),
                backgroundColor = colorResource(id = R.color.light_green)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("Zone")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                modifier = Modifier
                    .weight(2f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .height(80.dp), shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("Central Punjab")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .height(80.dp), shape = RoundedCornerShape(8.dp),
                backgroundColor = colorResource(id = R.color.light_green)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("District")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                modifier = Modifier
                    .weight(2f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .height(80.dp), shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("Kasur")
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .height(80.dp), shape = RoundedCornerShape(8.dp),
                backgroundColor = colorResource(id = R.color.light_green)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("Road Name")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                modifier = Modifier
                    .weight(3f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .height(80.dp), shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("Pattoki to Raiwind Road")
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .height(80.dp), shape = RoundedCornerShape(8.dp),
                backgroundColor = colorResource(id = R.color.light_green)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("Bridge Name")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                modifier = Modifier
                    .weight(3f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .height(80.dp), shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("Pattoki to Raiwind Road")
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .height(80.dp), shape = RoundedCornerShape(8.dp),
                backgroundColor = colorResource(id = R.color.light_green)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("Structure Type")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .height(80.dp), shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("Bridge")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .height(80.dp), shape = RoundedCornerShape(8.dp),
                backgroundColor = colorResource(id = R.color.light_green)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("Construction year")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .height(80.dp), shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveText("2021/01")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            TextButton(
                onClick = { navController.navigate("login") }, modifier = Modifier.background(
                    colorResource(R.color.light_green)
                )
            ) {
                Text(text = "Back", color = Color.Black, fontSize = 40.sp)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun BridgeImageGallery() {
    val  images :List<Int>  = listOf(R.drawable.bridge2,
        R.drawable.side,
        R.drawable.under,
        R.drawable.abutment,
        R.drawable.pier,
        R.drawable.side)
    //updated
    var state = rememberPagerState()
    //previous
    var imageResource by remember { mutableStateOf(R.drawable.bridge2) }
    var selectedImageType by remember { mutableStateOf(1) }
    val alphaValue by remember { mutableStateOf(1f) }
    Column(verticalArrangement = Arrangement.Top, modifier = Modifier.padding(20.dp)) {
        //image part
        /*Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentAlignment = Center
        ) {
            val back = SwipeAction(
                icon = painterResource(R.drawable.back),
                background = Color.Green,
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
                background = Color.Yellow,
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
                        .animateContentSize()
                        .alpha(alphaValue),
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
        }*/
        HorizontalPager(
            state = state,
            count = 6,
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
        ) { page ->
            selectedImageType = page
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Center
            ) {
                val image = images[page]
                val painter = rememberImagePainter(data = image)
                Image(
                    painter = painter,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateContentSize()
                        .alpha(alphaValue),
                    contentDescription = null
                )
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
                                    selectedImageType = state.currentPage+1
                                    imageResource = R.drawable.side
                                }
                                2 -> {
                                    selectedImageType = state.currentPage+1
                                    imageResource = R.drawable.under
                                }
                                3 -> {
                                    selectedImageType = state.currentPage+1
                                    imageResource = R.drawable.abutment
                                }
                                4 -> {
                                    selectedImageType = state.currentPage+1
                                    imageResource = R.drawable.pier
                                }
                                5 -> {
                                    selectedImageType = state.currentPage+1
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
/*
                repeat(3){
                    Log.d("checkvalue", "BridgeImageGallery: It value $it")
                    TextButton(
                        onClick = {
                            imageResource = imageList[it]
                            selectedImageType += 1
                            Log.d("checkvalue", "BridgeImageGallery: It value $selectedImageType")
                        }, modifier = if (selectedImageType == (it+1)) {
                            checkedModifier
                        } else {
                            defaultModifier
                        }
                    ) {
                        Text(text = nameList[it], fontSize = 40.sp, color = Color(0, 0, 128))
                    }
                }*/

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

/*@Composable
fun Greeting(message: String) {
    Column(
        modifier = Modifier
            .border(6.dp, MaterialTheme.colors.secondaryVariant, shape = RectangleShape)
            .background(Color.White)
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(text = "Hello $message!", fontSize = 40.sp)
//        Text(text = "Congratulations! You have won the lottery!", fontSize = 30.sp)
    }
}*/

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
//        WelcomeScreen(navController = rememberNavController())
        BridgeListItem()
//        KeyPad(onUpdate = {""})
    }
}