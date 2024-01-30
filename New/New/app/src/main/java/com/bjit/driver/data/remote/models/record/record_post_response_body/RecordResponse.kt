package com.bjit.driver.data.remote.models.record.record_post_response_body


import com.google.gson.annotations.SerializedName

data class RecordResponse(
    @SerializedName("archived")
    val archived: Boolean = false,
    @SerializedName("city")
    val city: Any = Any(),
    @SerializedName("city_district")
    val cityDistrict: Any = Any(),
    @SerializedName("county")
    val county: Any = Any(),
    @SerializedName("created")
    val created: String = "",
    @SerializedName("data")
    val `data`: Data = Data(),
    @SerializedName("geom")
    val geom: Geom = Geom(),
    @SerializedName("light")
    val light: String = "",
    @SerializedName("location_text")
    val locationText: String = "",
    @SerializedName("modified")
    val modified: String = "",
    @SerializedName("modified_by")
    val modifiedBy: String = "",
    @SerializedName("neighborhood")
    val neighborhood: Any = Any(),
    @SerializedName("occurred_from")
    val occurredFrom: String = "",
    @SerializedName("occurred_to")
    val occurredTo: String = "",
    @SerializedName("road")
    val road: Any = Any(),
    @SerializedName("schema")
    val schema: String = "",
    @SerializedName("state")
    val state: String = "",
    @SerializedName("uuid")
    val uuid: String = "",
    @SerializedName("weather")
    val weather: String = ""
)