package com.example.shopapi.ui.auth.logIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapi.model.Login
import com.example.shopapi.network.Resource
import com.example.shopapi.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val authRepository: AuthRepository) : ViewModel() {


    private var logInLiveData = MutableLiveData<Resource<Login>>()

    var _logInLiveData : LiveData<Resource<Login>> = logInLiveData

     fun logIn(email: String, password: String,rememberMe:Boolean) {


        viewModelScope.launch {
            withContext(Dispatchers.IO) {
              val result =  authRepository.logIn(email, password,rememberMe)
                logInLiveData.postValue(result)
            }
        }

    }

}