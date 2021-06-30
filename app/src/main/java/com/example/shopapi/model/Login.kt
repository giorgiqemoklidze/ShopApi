package com.example.shopapi.model

import com.google.gson.annotations.SerializedName

data class Login(

    @SerializedName("token")
    val token: String?,
    @SerializedName("user_id")
    val userId: Int?
)