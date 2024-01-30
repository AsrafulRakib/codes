package com.dynamicdriller.locationtracker

import android.Manifest
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dynamicdriller.locationtracker.locationservices.getLocation
import com.dynamicdriller.locationtracker.ui.theme.LocationTrackerTheme
import com.dynamicdriller.locationtracker.viewmodel.LocationViewModel
import java.util.*


class MainActivity : ComponentActivity() {
    private val locationViewModel: LocationViewModel by viewModels()
    private var latitude = 0.0
    private var longitude = 0.0

    val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                detectUserLocation()
                //Toast.makeText(this, "precise granted", Toast.LENGTH_SHORT).show()
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                detectUserLocation()
                //Toast.makeText(this, "approximate granted", Toast.LENGTH_SHORT).show()
            } else -> {
            //Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
        }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locationPermissionRequest.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION))
        setContent {
            var location by remember { mutableStateOf("") }
            locationViewModel.locationLiveData.observe(this){
                location = it.toString()
            }
            LocationTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(location)
                }
            }
        }
    }
    private fun detectUserLocation() {
        getLocation(this) {
            locationViewModel.setNewLocation(it)
            latitude = it.latitude
            longitude = it.longitude
            val geocoder: Geocoder
            val addresses: List<Address>?
            geocoder = Geocoder(this, Locale.getDefault())

            addresses = geocoder.getFromLocation(
                latitude,
                longitude,
                1
            ) // Here 1 represent max location result to returned, by documents it recommended 1 to 5


            val address: String =
                addresses!![0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

            val city: String = addresses[0].locality
            val state: String = addresses[0].adminArea
            val country: String = addresses[0].countryName
            val knownName: String = addresses[0].featureName // Only if available else return NULL

            setContent(){
                Box(contentAlignment = Alignment.Center){
                    Greeting(name = "$knownName, $city, $state, $country")
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LocationTrackerTheme {
        Greeting("Android")
    }
}