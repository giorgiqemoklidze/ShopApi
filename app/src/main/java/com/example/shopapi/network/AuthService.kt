package com.example.shopapi.network

import com.example.shopapi.model.Login
import com.example.shopapi.model.SignUp
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @POST("login")
    @FormUrlEncoded
    suspend fun logIn(
        @Field("email") email: String,
        @Field("Password") password: String
    ): Response<Login>

    @POST("signUp")
    @FormUrlEncoded
    suspend fun signUp(
        @Field("email") email: String,
        @Field("Password") password: String,
        @Field("full_name") fullName: String
    ): Response<SignUp>

}