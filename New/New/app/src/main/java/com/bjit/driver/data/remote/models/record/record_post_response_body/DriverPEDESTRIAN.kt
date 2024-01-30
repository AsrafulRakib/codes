package com.bjit.driver.data.remote.models.record.record_post_response_body


import com.google.gson.annotations.SerializedName

data class DriverPEDESTRIAN(
    @SerializedName("_localId")
    val localId: String = "",
    @SerializedName("PEDESTRIAN ACTION / পথচারীর কার্যক্রম")
    val pedestrianAction: String = "",
    @SerializedName("PEDESTRIAN AGE / পথচারীর বয়স")
    val pedestrianAge: Int = 0,
    @SerializedName("PEDESTRIAN INJURY / পথচারীর ক্ষত")
    val pedestrianInjury: String = "",
    @SerializedName("PEDESTRIAN LOCATION / পথচারীর অবস্থান")
    val pedestrianLocation: String = "",
    @SerializedName("PEDESTRIAN SEX / পথচারীর লিঙ্গ")
    val pedestrianSex: String = "",
    @SerializedName("VEHICLE NUMBER / যানবাহন নাম্বার")
    val vehicleNumber: String = ""
)