package com.bjit.driver.data.remote

import com.bjit.driver.data.remote.models.login.LoginModel
import com.bjit.driver.data.remote.models.login.LoginResponse
import com.bjit.driver.data.remote.models.record.record_post_body.RecordPost
import com.bjit.driver.data.remote.models.record.record_post_response_body.RecordResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface DriverAPI {
    @Headers("Content-Type: application/json")
    @POST("api-token-auth/")
    suspend fun postLogin(
        @Body loginModel: LoginModel,
    ): LoginResponse

    @Headers("Authorization: Token 6b275d2e1084cd273fc0a877ed2707aeecbb26c0")
    @POST("/api/records/")
    suspend fun postRecord(
        @Body record: RecordPost
    ): RecordResponse
}