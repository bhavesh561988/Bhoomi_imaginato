package com.example.myapplication.repository.model.login

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class Login(

    @PrimaryKey @SerializedName("userId") var userId: String = "",
    @SerializedName("userName") var userName: String = "",
    var xaccheader: String = ""
)
