package com.bjit.driver.ui.screens.recordconstantscreen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bjit.driver.ui.screens.homescreen.HomeViewModel
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordConstantScreen(
    navController: NavController,
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
//    val recordsConstantViewModel: RecordsConstantViewModel = hiltViewModel()
//    val context = LocalContext.current
//    val calendar = Calendar.getInstance()
//    var selectedDateText by remember {
//        mutableStateOf(
//            homeViewModel.currentRecord.value.occurredFrom ?: ""
//        )
//    }
//    var selectedTimeText by remember {
//        mutableStateOf(
//            homeViewModel.currentRecord.value.occurredFrom ?: ""
//        )
//    }
//    // Fetching current year, month and day
//    val year = calendar[Calendar.YEAR]
//    val month = calendar[Calendar.MONTH]
//    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
//    val datePicker = DatePickerDialog(
//        context,
//        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
//            selectedDateText =
//                "$selectedYear-${if (selectedMonth + 1 <= 10) "0" else ""}${selectedMonth + 1}-${if (selectedDayOfMonth + 1 <= 10) "0" else ""}$selectedDayOfMonth"
//        }, year, month, dayOfMonth
//    )
//    datePicker.datePicker.minDate = calendar.timeInMillis
//    // Fetching current hour, and minute
//    val hour = calendar[Calendar.HOUR_OF_DAY]
//    val minute = calendar[Calendar.MINUTE]
//    val timePicker = TimePickerDialog(
//        context,
//        { _, selectedHour: Int, selectedMinute: Int ->
//            selectedTimeText = "$selectedHour:$selectedMinute"
//        }, hour, minute, false
//    )
//
//
//    Scaffold(modifier = modifier) {
//        Box(modifier = Modifier.padding(it)) {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = if (selectedDateText.isNotEmpty()) {
//                        "Selected date is $selectedDateText"
//                    } else {
//                        "Please pick a date"
//                    }
//                )
//                Text(
//                    text = if (selectedTimeText.isNotEmpty()) {
//                        "Selected Time is $selectedTimeText"
//                    } else {
//                        "Please pick a time"
//                    }
//                )
//                Button(
//                    onClick = {
//                        timePicker.show()
//                        datePicker.show()
//                    }
//                ) {
//                    Text(text = "Select a date and time")
//                }
//                Text(text = "Current location is X and Y")
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    contentAlignment = Alignment.CenterEnd
//                ) {
//                    Button(onClick = {
////                        navController.navigate(Screen.PureImageScreen.route)
//                        homeViewModel.updateDateAndTime(selectedDateText, selectedTimeText)
//                    }) {
//                        Text(text = "Next")
//                    }
//                }
//            }
//        }
//    }
}