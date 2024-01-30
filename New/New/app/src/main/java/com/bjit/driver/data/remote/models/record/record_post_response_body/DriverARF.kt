package com.bjit.driver.data.remote.models.record.record_post_response_body


import com.google.gson.annotations.SerializedName

data class DriverARF(
    @SerializedName("ACCIDENT REPORT NO / দূর্ঘটনার ক্রমিক নম্বর")
    val accidentReportNo: Int = 0,
    @SerializedName("ACCIDENT SEVERITY / দুর্ঘটনার মাত্রা")
    val accidentSeverity: String = "",
    @SerializedName("COLLISION TYPE / সংঘর্ষের ধরন আঘাত")
    val collisionType: String = "",
    @SerializedName("DAY / দিন")
    val day: String = "",
    @SerializedName("DISTRICT/MET POL / জিলা/মেট্রো পুলিশ")
    val districtMetPol: String = "",
    @SerializedName("DIVIDER? / রোড ডিভাইডার?")
    val divider: String = "",
    @SerializedName("FIR NO / প্রাথমিক তথ্য বিবরণী")
    val firNo: Int = 0,
    @SerializedName("JUNCTION TYPE / সংযোগ স্থলের ধরণ")
    val junctionType: String = "",
    @SerializedName("KM / KM")
    val kmKm: Int = 0,
    @SerializedName("LOCATION TYPE / এলাকার ধরণ")
    val locationType: String = "",
    @SerializedName("LOCATION / অবস্থান")
    val location: String = "",
    @SerializedName("_localId")
    val localId: String = "",
    @SerializedName("MOVEMENT / গাড়ী চলাচলের দিক")
    val movement: String = "",
    @SerializedName("NODE 1 / NODE 1")
    val node1Node1: Int = 0,
    @SerializedName("NODE 2 / NODE 2")
    val node2Node2: Int = 0,
    @SerializedName("NODE MAP / নোড ম্যাপ")
    val nodeMap: Int = 0,
    @SerializedName("NUMBER OF DRIVER CASUALTIES / হতাহত ড্রাইভারের সংখ্যা")
    val numberOfDriverCasualties: Int = 0,
    @SerializedName("NUMBER OF PASSENGER CASUALTIES / হতাহত যাত্রীর সংখ্যা")
    val numberOfPassengerCasualties: Int = 0,
    @SerializedName("NUMBER OF PEDESTRIAN CASUALTIES / হতাহত পথচারীর সংখ্যা")
    val numberOfPedestrianCasualties: Int = 0,
    @SerializedName("NUMBER OF VEHICLES INVOLVED / দূর্ঘটনা কবলিত গাড়ীর সংখ্যা")
    val numberOfVehiclesInvolved: Int = 0,
    @SerializedName("ROAD CLASS / রাস্তার শ্রেণী")
    val roadClass: String = "",
    @SerializedName("ROAD FEATURE / রাস্তার বৈশিষ্ট্য")
    val roadFeature: String = "",
    @SerializedName("ROAD GEOMETRY / রাস্তার জ্যামিতিক বিবরণ")
    val roadGeometry: String = "",
    @SerializedName("ROUTE / রাস্তা")
    val route: Int = 0,
    @SerializedName("SUMMARY OF ACCIDENT / দূর্ঘটনার সংক্ষিপ্ত বিবরণ")
    val summaryOfAccident: String = "",
    @SerializedName("SURFACE CONDITION / রাস্তার উপরিভাগের অবস্থা")
    val surfaceCondition: String = "",
    @SerializedName("SURFACE QUALITY / রাস্তার প্রকৃতি")
    val surfaceQuality: String = "",
    @SerializedName("SURFACE TYPE / রাস্তার প্রকারভেদ")
    val surfaceType: String = "",
    @SerializedName("THANA / থানা")
    val thana: String = "",
    @SerializedName("TRAFFIC CONTROL / ট্রাফিক নিয়ন্ত্রণ ব্যবস্থা")
    val trafficControl: String = "",
    @SerializedName("X100M / X100M")
    val x100MX100M: Int = 0
)