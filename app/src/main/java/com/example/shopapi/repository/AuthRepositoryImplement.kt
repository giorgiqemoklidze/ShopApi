package com.example.shopapi.repository

import com.example.shopapi.model.Error
import com.example.shopapi.model.Login
import com.example.shopapi.model.SignUp
import com.example.shopapi.network.AuthService
import com.example.shopapi.network.Resource
import com.example.shopapi.user_data.UserPreference
import com.google.gson.Gson
import javax.inject.Inject

class AuthRepositoryImplement @Inject constructor(
    private val authService: AuthService,
    private val userPreference: UserPreference
) : AuthRepository {


    override suspend fun logIn(
        email: String,
        password: String,
        rememberMe: Boolean
    ): Resource<Login> {
        return try {
            val response = authService.logIn(email, password)
            if (response.isSuccessful) {

                val body = response.body()!!

                userPreference.saveSession(rememberMe)
                userPreference.saveToken(body.token)
                Resource.succsess(body)


            } else {
                val errorModel = Gson().fromJson(response.errorBody()!!.string(),Error::class.java)
                Resource.error(errorModel.error)

            }
        } catch (e: Exception) {

            Resource.error(e.message.toString())

        }
    }

    override suspend fun signUp(
        email: String,
        fullName: String,
        password: String,
    ): Resource<SignUp> {
        return try {
            val response = authService.signUp(email,fullName, password)
            if (response.isSuccessful) {

                val body = response.body()!!

                Resource.succsess(body)


            } else {
                val errorModel = Gson().fromJson(response.errorBody()!!.string(),Error::class.java)
                Resource.error(errorModel.error)

            }
        } catch (e: Exception) {

            Resource.error(e.message.toString())

        }
    }


}