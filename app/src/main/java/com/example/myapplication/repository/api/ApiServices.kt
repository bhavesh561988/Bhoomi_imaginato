package com.example.myapplication.repository.api

import androidx.lifecycle.LiveData
import com.example.myapplication.repository.model.login.LoginSource
import com.example.myapplication.request.LoginRequest
import com.kotlin.mvvm.repository.api.network.Resource
import retrofit2.http.*



/**
 * Api services to communicate with server
 *
 */
interface ApiServices {

    @Headers("Content-Type: application/json","IMSI: 357175048449937","IMEI: 510110406068589")
    @POST("api/login")
    fun getApiLoginDetails(@Body options: LoginRequest): LiveData<Resource<LoginSource>>

}
