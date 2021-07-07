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
        @Field("password") password: String
    ): Response<Login>

    @POST("register")
    @FormUrlEncoded
    suspend fun signUp(
        @Field("email") email: String,
        @Field("full_name") fullName: String,
        @Field("password") password: String
    ): Response<SignUp>

}