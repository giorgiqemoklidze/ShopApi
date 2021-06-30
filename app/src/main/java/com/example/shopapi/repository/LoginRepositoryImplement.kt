package com.example.shopapi.repository

import com.example.shopapi.model.Login
import com.example.shopapi.network.ApiService
import com.example.shopapi.network.Resource
import javax.inject.Inject

class LoginRepositoryImplement @Inject constructor(val apiService: ApiService) : LoginRepository {


    override suspend fun logIn(email: String, password: String): Resource<Login> {
        try {
            val response = apiService.logIn(email, password)
            if (response.isSuccessful) {

                return Resource.succsess(response.body()!!)

            } else {

                return Resource.error(response.errorBody()!!.string())

            }
        } catch (e: Exception) {

            return Resource.error(e.message.toString())

        }
    }


}