package com.example.shopapi.repository

import com.example.shopapi.model.Login
import com.example.shopapi.model.SignUp
import com.example.shopapi.network.Resource

interface AuthRepository {

    suspend fun logIn(email: String, password: String,rememberMe:Boolean): Resource<Login>

    suspend fun signUp(email: String,fullName : String ,password: String): Resource<SignUp>

}