package com.bjit.driver.data.remote.models.record.record_post_response_body


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("driverARF")
    val driverARF: DriverARF = DriverARF(),
    @SerializedName("driverCONTRIBUTORYFACTOR")
    val driverCONTRIBUTORYFACTOR: DriverCONTRIBUTORYFACTOR = DriverCONTRIBUTORYFACTOR(),
    @SerializedName("driverPASSENGER")
    val driverPASSENGER: List<DriverPASSENGER> = listOf(),
    @SerializedName("driverPEDESTRIAN")
    val driverPEDESTRIAN: List<DriverPEDESTRIAN> = listOf(),
    @SerializedName("driverRCFDetails")
    val driverRCFDetails: DriverRCFDetails = DriverRCFDetails(),
    @SerializedName("driverVEHICLE")
    val driverVEHICLE: List<DriverVEHICLE> = listOf()
)