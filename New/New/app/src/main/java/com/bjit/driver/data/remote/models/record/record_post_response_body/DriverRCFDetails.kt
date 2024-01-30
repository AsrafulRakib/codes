package com.bjit.driver.data.remote.models.record.record_post_response_body


import com.google.gson.annotations.SerializedName

data class DriverRCFDetails(
    @SerializedName("ACCIDENT SEVERITY / দুর্ঘটনার মাত্রা")
    val accidentSeverity: String = "",
    @SerializedName("CASUALTIES NUMBER OF DEAD / দুর্ঘটনায় হতাহত মৃতের সংখ্যা")
    val casualtiesNumberOfDead: Int = 0,
    @SerializedName("CASUALTIES NUMBER OF GRIEVOUSLY INJURED / দুর্ঘটনায় মারাত্মক আঘাত প্রাপ্তের সংখ্যা")
    val casualtiesNumberOfGrievouslyInjured: Int = 0,
    @SerializedName("CASUALTIES NUMBER OF SIMPLY INJURED / দুর্ঘটনায় সাধারণ আঘাত প্রাপ্তের সংখ্যা")
    val casualtiesNumberOfSimplyInjured: Int = 0,
    @SerializedName("COLLISION TYPE (MOST SEVERE) / সংঘর্ষের ধরন (বেশি মাত্রার টি গ্রহণযোগ্য)")
    val collisionTypeMostSevere: String = "",
    @SerializedName("CONTRIBUTORY FACTOR / সহায়ক কারণ")
    val contributoryFactor: List<String> = listOf(),
    @SerializedName("LOCATION NAME OF CITY/TOWN/VILLAGE / নগর/শহর/গ্রামের অবস্থানের নাম")
    val locationNameOfCityTownVillage: String = "",
    @SerializedName("LOCATION NAME OF ROAD / সড়কের অবস্থানের নাম")
    val locationNameOfRoad: String = "",
    @SerializedName("LOCATION NEAREST ESTABLISHMENT/LANDMARK (ESTIMATE HOW MANY METERS AWAY FROM CRASH) / অবস্থান নিকটবর্তী স্থাপনা/চিহ্নিত স্থান (দুর্ঘটনা স্থল হইতে আনুমানিক দূরত্ব)")
    val locationNearestEstablishmentLandmarkEstimateHowManyMetersAwayFromCrash: String = "",
    @SerializedName("LOCATION SKETCH / নকশা/ খসরা চিত্র")
    val locationSketch: String = "",
    @SerializedName("_localId")
    val localId: String = "",
    @SerializedName("NAME OF REPORTER / প্রতিবেদকের নাম")
    val nameOfReporter: String = "",
    @SerializedName("NUMBER OF ANIMAL DRAWN INVOLVED / জড়িত পশু চালিত বাহনের সংখ্যা")
    val numberOfAnimalDrawnInvolved: Int = 0,
    @SerializedName("NUMBER OF ARTICULATED TRUCK INVOLVED / জড়িত আর্টিকুলেটেড ট্রাকের সংখ্যা")
    val numberOfArticulatedTruckInvolved: Int = 0,
    @SerializedName("NUMBER OF BABY TAXI INVOLVED / জড়িত বেবি ট্যাক্সির সংখ্যা")
    val numberOfBabyTaxiInvolved: Int = 0,
    @SerializedName("NUMBER OF BICYCLE INVOLVED / জড়িত বাই সাইকেলের সংখ্যা")
    val numberOfBicycleInvolved: Int = 0,
    @SerializedName("NUMBER OF BUS INVOLVED / জড়িত বাসের সংখ্যা")
    val numberOfBusInvolved: Int = 0,
    @SerializedName("NUMBER OF CAR INVOLVED / জড়িত কারের সংখ্যা")
    val numberOfCarInvolved: Int = 0,
    @SerializedName("NUMBER OF HEAVY TRUCK INVOLVED / জড়িত ভারী ট্রাকের সংখ্যা")
    val numberOfHeavyTruckInvolved: Int = 0,
    @SerializedName("NUMBER OF JEEP INVOLVED / জড়িত জীপের সংখ্যা")
    val numberOfJeepInvolved: Int = 0,
    @SerializedName("NUMBER OF MICROBUS INVOLVED / জড়িত মাইক্রোবাসের সংখ্যা")
    val numberOfMicroBusInvolved: Int = 0,
    @SerializedName("NUMBER OF MINIBUS INVOLVED / জড়িত মিনিবাসের সংখ্যা")
    val numberOfMinibusInvolved: Int = 0,
    @SerializedName("NUMBER OF MOTOR CYCLE INVOLVED / জড়িত মোটর সাইকেলের সংখ্যা")
    val numberOfMotorcycleInvolved: Int = 0,
    @SerializedName("NUMBER OF OIL TANKER INVOLVED / জড়িত অয়েল ট্যাঙ্কারের সংখ্যা")
    val numberOfOilTankerInvolved: Int = 0,
    @SerializedName("NUMBER OF OTHER INVOLVED / অন্যান্য জড়িত সংখ্যা")
    val numberOfOtherInvolved: Int = 0,
    @SerializedName("NUMBER OF PICK UP INVOLVED / জড়িত পিক আপের সংখ্যা")
    val numberOfPickupInvolved: Int = 0,
    @SerializedName("NUMBER OF PUSHCART INVOLVED / জড়িত ঠেলাগাড়ির সংখ্যা")
    val numberOfPushcartInvolved: Int = 0,
    @SerializedName("NUMBER OF RICKSHAW INVOLVED / জড়িত রিকশার সংখ্যা")
    val numberOfRickshawInvolved: Int = 0,
    @SerializedName("NUMBER OF TEMPO INVOLVED / জড়িত টেম্পোর সংখ্যা")
    val numberOfTempoInvolved: Int = 0,
    @SerializedName("NUMBER OF TRACTOR INVOLVED / জড়িত ট্রাক্টরের সংখ্যা")
    val numberOfTractorInvolved: Int = 0,
    @SerializedName("NUMBER OF TRUCK <3POINT5T INVOLVED / ট্রাকের সংখ্যা <3POINT5T জড়িত")
    val numberOfTruck3point5TInvolved: Int = 0,
    @SerializedName("NUMBER OF UNKNOWN INVOLVED / জড়িত অজানা সংখ্যা")
    val numberOfUnknownInvolved: Int = 0,
    @SerializedName("TRAFFIC POLICE ZONE / ট্রাফিক পুলিশ জোন")
    val trafficPoliceZone: String = ""
)