package com.bjit.driver.repository

import com.bjit.driver.data.remote.DriverAPI
import com.bjit.driver.data.remote.models.login.LoginModel
import com.bjit.driver.data.remote.models.record.record_post_body.RecordPost
import com.bjit.driver.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ActivityScoped
class DriverRepository @Inject constructor(private val api: DriverAPI) {

    suspend fun postLogin(loginModel: LoginModel) =
        flow {
            emit(Resource.Loading())
            try {
                emit(Resource.Success(api.postLogin(loginModel)))
            } catch (exception: Exception) {
                emit(
                    Resource.Error(
                        errorMessage = exception.message?.toString()
                            ?: "An unknown exception occurred"
                    )
                )
            }
        }

    suspend fun postRecord(record: RecordPost) =
        flow {
            emit(Resource.Loading())
            try {
                emit(Resource.Success(api.postRecord(record)))
            } catch (exception: Exception) {
                emit(
                    Resource.Error(
                        errorMessage = exception.message?.toString()
                            ?: "An unknown exception occurred"
                    )
                )
            }
        }
}