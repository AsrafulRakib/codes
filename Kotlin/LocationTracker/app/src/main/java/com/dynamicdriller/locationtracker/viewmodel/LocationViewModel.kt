package com.dynamicdriller.locationtracker.viewmodel

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LocationViewModel:ViewModel() {
    val locationLiveData : MutableLiveData<Location> = MutableLiveData()
    fun setNewLocation(location: Location) {
        locationLiveData.value = location
    }
}