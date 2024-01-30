package com.dynamicdriller.locationtracker.locationservices

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient


@SuppressLint("MissingPermission")
fun getLocation(context: Context, callback: (Location) -> Unit) {
    val locationProvider = FusedLocationProviderClient(context)
    locationProvider.lastLocation
        .addOnCompleteListener {
            if (it.isSuccessful) {
                val location = it.result
                location?.let {
                    callback(it)
                }
            }
        }
}