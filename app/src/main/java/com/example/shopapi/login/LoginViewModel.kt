package com.example.shopapi.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapi.di.ApiModule
import com.example.shopapi.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val loginRepository: LoginRepository) : ViewModel() {




     fun logIn(email: String, password: String) {


        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                loginRepository.logIn(email, password)
            }
        }

    }

}