package com.bjit.driver.data.remote.models.record.record_post_body


import com.google.gson.annotations.SerializedName

data class RecordPost(
    @SerializedName("data")
    val `data`: Data = Data(),
    @SerializedName("geom")
    val geom: String = "",
    @SerializedName("light")
    val light: String = "",
    @SerializedName("location_text")
    val locationText: String = "",
    @SerializedName("occurred_from")
    val occurredFrom: String = "",
    @SerializedName("occurred_to")
    val occurredTo: String = "",
    @SerializedName("schema")
    val schema: String = "",
    @SerializedName("state")
    val state: String = "",
    @SerializedName("weather")
    val weather: String = ""
)