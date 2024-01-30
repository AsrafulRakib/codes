package com.bjit.driver.data.remote.models.login

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)