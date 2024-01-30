package com.bjit.driver.data.remote.models.record.record_post_response_body


import com.google.gson.annotations.SerializedName

data class DriverPASSENGER(
    @SerializedName("_localId")
    val localId: String = "",
    @SerializedName("PASSENGER ACTION / যাত্রীর কার্যক্রম")
    val passengerAction: String = "",
    @SerializedName("PASSENGER AGE / যাত্রীর বয়স")
    val passengerAge: Int = 0,
    @SerializedName("PASSENGER INJURY / যাত্রীর ক্ষত")
    val passengerInjury: String = "",
    @SerializedName("PASSENGER POSITION / যাত্রীর অবস্থান")
    val passengerPosition: String = "",
    @SerializedName("PASSENGER SEX / যাত্রীর লিঙ্গ")
    val passengerSex: String = "",
    @SerializedName("VEHICLE NUMBER / যানবাহন নাম্বার")
    val vehicleNumber: String = ""
)