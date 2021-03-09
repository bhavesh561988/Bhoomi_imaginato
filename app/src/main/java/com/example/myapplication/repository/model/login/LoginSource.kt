package com.example.myapplication.repository.model.login

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class LoginSource(@SerializedName("errorCode") var errorCode: String = "",
                       @SerializedName("errorMessage") var errorMessage: String = "",
                       @Nullable
                       @SerializedName("user") val login: Login)
