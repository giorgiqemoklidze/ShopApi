package com.example.shopapi.network

import com.example.shopapi.model.Login
import com.example.shopapi.model.ProfileCompleteStatus
import com.example.shopapi.model.SignUp
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

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


    @POST("profile")
    @FormUrlEncoded
    suspend fun completeProfileStatus(
        @Field("user_id") user_id: Int
    ): Response<ProfileCompleteStatus>

    @POST("complete-profile")
    @Multipart
    suspend fun completeProfile(
        @Part("user_id") user_id: Int,
        @Part("address") address: String,
        @Part("card_number") card_number: String,
        @Part("card_holder_name") card_holder_name: String,
        @Part("expiry_date") expiry_date: Int,
        @Part("security_code") security_code: Int,
        @Part("floor_apartment") floor_apartment: Boolean,
        @Part("file") file : MultipartBody.Part
    ): Response<ProfileCompleteStatus>

}