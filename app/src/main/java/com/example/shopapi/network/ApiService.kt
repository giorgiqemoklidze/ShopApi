package com.example.shopapi.network

import com.example.shopapi.model.Login
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    @FormUrlEncoded
    suspend fun logIn(
        @Field("email") email: String,
        @Field("Password") password: String
    ): Response<Login>

}