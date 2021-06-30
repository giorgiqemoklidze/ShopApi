package com.example.shopapi.repository

import com.example.shopapi.model.Login
import com.example.shopapi.network.Resource

interface LoginRepository {

    suspend fun logIn(email: String, password: String): Resource<Login>

}