package com.example.shopapi.ui.splash

import androidx.lifecycle.ViewModel
import com.example.shopapi.user_data.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val userPreference: UserPreference) : ViewModel() {

    fun isLoggined() = userPreference.hasSession()

}