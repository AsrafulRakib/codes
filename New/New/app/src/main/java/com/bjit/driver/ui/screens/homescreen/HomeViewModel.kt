package com.bjit.driver.ui.screens.homescreen

import androidx.lifecycle.ViewModel
import com.bjit.driver.repository.DriverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: DriverRepository,
) : ViewModel() {
//    var listOfRecords = mutableStateOf<List<RecordPost>>(listOf())
//    var currentRecord = mutableStateOf(RecordPost())
//    fun updateConstants() {
//        currentRecord.value.copy(
//            city = "",
//            occurredFrom = "",
//            occurredTo = "",
//            locationText = "",
//            weather = "",
//            light = "",
//            geom = "",
//            county = "",
//            state = "",
//            schema = ""
//        )
//    }
//
//    fun printCurrent() {
//        Timber.e(currentRecord.toString())
//        Timber.e(currentRecord.value.data.toString())
//        Timber.e(currentRecord.value.occurredFrom)
//    }
//
//    fun updateDateAndTime(date: String, time: String) {
//        currentRecord.value = currentRecord.value.copy(
//            occurredFrom = date + "T$time" + ":42.420Z", occurredTo = date + "T$time" + ":42.420Z"
//        )
//    }
//
//    fun updatePureImage(image: String, singleLineText: String, paragraphText: String) {
//        val pureImageDetails = DriverPureImageDetails(
//            image = image, singleLineText = singleLineText, paragraphText = paragraphText
//        )
//        currentRecord.value = currentRecord.value.copy(
//            data = currentRecord.value.data?.copy(
//                driverPureImageDetails = pureImageDetails
//            ) ?: Data(driverMultipleContent = null, driverPureImageDetails = pureImageDetails)
//        )
//    }
//
//    fun setCurrentRecord(pureImage: PureImage) {
//        currentRecord.value = pureImage
//    }
//
//    fun createNewRecord() {
//        currentRecord.value = PureImage()
//    }
//
//    fun saveData() {
//        listOfRecords.value = listOfRecords.value + currentRecord.value
//    }
//
//    fun testImageTestPost() {
//        val imageTest = RecordPost()
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = repository.postRecord(imageTest)
//            response
//                .catch {
//                    Timber.e("Error $this")
//                }
//                .collect { resource ->
//                    when (resource) {
//                        is Resource.Loading -> {
////                            isLoading.value = true
//                        }
//                        is Resource.Success -> {
//                            Timber.e("Success: ${resource.data}")
////                            isLoading.value = false
////                            isLoggedIn.value = true
////                            settingsRepository.setIsLoggedIn(true)
////                            resource.data?.token?.let { settingsRepository.setAuthToken(token = it) }
//                        }
//                        is Resource.Error -> {
//                            Timber.e("Error: ${resource.errorMessage}")
////                            isLoading.value = false
////                            isLoggedIn.value = false
////                            settingsRepository.setIsLoggedIn(false)
////                            loginError.value = resource.errorMessage!!
//                        }
//                    }
//                }
//        }
//    }
}