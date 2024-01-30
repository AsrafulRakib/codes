package com.bjit.driver.data.remote.models.record.record_post_response_body


import com.google.gson.annotations.SerializedName

data class DriverCONTRIBUTORYFACTOR(
    @SerializedName("CONTRIBUTORY FACTOR / সহায়ক কারণ")
    val contributoryFactor: List<String> = listOf(),
    @SerializedName("_localId")
    val localId: String = ""
)