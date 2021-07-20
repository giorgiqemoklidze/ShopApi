package com.example.shopapi.user_data

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreference @Inject constructor(@ApplicationContext context: Context) {

    companion object {
        const val SASSION = "HAS_SESSION"
        const val TOKEN = "TOKEN"
        const val USER_ID = "USER_ID"
    }


    private val sharedPreference: SharedPreferences by lazy {
        context.getSharedPreferences("user", Context.MODE_PRIVATE)
    }


    fun saveSession(session: Boolean) {
        sharedPreference.edit().putBoolean(SASSION, session).apply()
    }

    fun hasSession() = sharedPreference.getBoolean(SASSION, false)

    fun saveToken(token : String){
        sharedPreference.edit().putString(TOKEN, token).apply()
    }

    fun token() = sharedPreference.getString(SASSION, "")

    fun saveUserId(userID: Int){
        sharedPreference.edit().putInt(USER_ID, userID).apply()
    }

    fun userID() = sharedPreference.getInt(USER_ID, 0)

}