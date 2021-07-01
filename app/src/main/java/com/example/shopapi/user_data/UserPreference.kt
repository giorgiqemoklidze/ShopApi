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
    }

    private val sharedPreference: SharedPreferences by lazy {
        context.getSharedPreferences("user", Context.MODE_PRIVATE)
    }


    fun saveSession(session: Boolean) {
        sharedPreference.edit().putBoolean(SASSION, session).apply()
    }

    fun hasSession() = sharedPreference.getBoolean(SASSION, false)

}