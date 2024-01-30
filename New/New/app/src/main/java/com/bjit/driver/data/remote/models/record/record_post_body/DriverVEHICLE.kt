package com.bjit.driver.data.remote.models.record.record_post_body


import com.google.gson.annotations.SerializedName

data class DriverVEHICLE(
    @SerializedName("ALCOHOL / মদ্যপ কিনা?")
    val alcohol: String = "",
    @SerializedName("DRIVER AGE / চালকের বয়স")
    val driverAge: Int = 0,
    @SerializedName("DRIVER INJURY / চালকের ক্ষত")
    val driverInjury: String = "",
    @SerializedName("DRIVER SEX / চালকের লিঙ্গ")
    val driverSex: String = "",
    @SerializedName("DRIVING LICENSE DISTRICT / ড্রাইভিং লাইসেন্স জেলা")
    val drivingLicenseDistrict: String = "",
    @SerializedName("DRIVING LICENSE NUMBER / ড্রাইভিং লাইসেন্স নম্বর")
    val drivingLicenseNumber: String = "",
    @SerializedName("_localId")
    val localId: String = "",
    @SerializedName("SEAT BELT/HELMET / সিট বেল্ট/হেলমেট")
    val seatBeltHelmet: String = "",
    @SerializedName("VALID FITNESS CERTIFICATE / বৈধ ফিটনেস সার্টিফিকেট")
    val validFitnessCertificate: String = "",
    @SerializedName("VEHICLE DAMAGE / যানবাহনের ক্ষতি (দুর্ঘটনা জনিত)")
    val vehicleDamage: List<String> = listOf(),
    @SerializedName("VEHICLE DEFECT / যানবাহনের ত্রুটি")
    val vehicleDefect: List<String> = listOf(),
    @SerializedName("VEHICLE LOADING / যানবাহনের মালামাল বোঝাই")
    val vehicleLoading: String = "",
    @SerializedName("VEHICLE MANOEUVRE / যানবাহন চলাচলের ধরন")
    val vehicleManoeuvre: String = "",
    @SerializedName("VEHICLE REGISTRATION DISTRICT / যানবাহন রেজিস্ট্রেশন জেলা")
    val vehicleRegistrationDistrict: String = "",
    @SerializedName("VEHICLE REGISTRATION NUMBER / যানবাহন রেজিস্ট্রেশন নম্বর")
    val vehicleRegistrationNumber: String = "",
    @SerializedName("VEHICLE TYPE / যানবাহনের ধরণ")
    val vehicleType: String = ""
)