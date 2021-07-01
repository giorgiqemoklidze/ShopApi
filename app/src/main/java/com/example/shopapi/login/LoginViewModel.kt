package com.example.shopapi.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapi.model.Login
import com.example.shopapi.network.Resource
import com.example.shopapi.repository.LoginRepository
import com.example.shopapi.user_data.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val loginRepository: LoginRepository,val userPreference: UserPreference) : ViewModel() {


    private var logInLiveData = MutableLiveData<Resource<Login>>()

    var _logInLiveData : LiveData<Resource<Login>> = logInLiveData

     fun logIn(email: String, password: String) {


        viewModelScope.launch {
            withContext(Dispatchers.IO) {
              val result =  loginRepository.logIn(email, password)
                logInLiveData.postValue(result)
            }
        }

    }

    fun saveSession(isChecked:Boolean){
      userPreference.saveSession(isChecked)
    }

}