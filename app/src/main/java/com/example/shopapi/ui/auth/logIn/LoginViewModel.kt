package com.example.shopapi.ui.auth.logIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapi.model.Login
import com.example.shopapi.model.ProfileCompleteStatus
import com.example.shopapi.network.Resource
import com.example.shopapi.repository.AuthRepository
import com.example.shopapi.repository.completeProfileRepository.CompleteProfileRepo
import com.example.shopapi.user_data.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val authRepository: AuthRepository, private val completeProfileRepository: CompleteProfileRepo,private val pref: UserPreference) : ViewModel() {


    private var logInLiveData = MutableLiveData<Resource<Login>>()

    var _logInLiveData : LiveData<Resource<Login>> = logInLiveData

    private var completeProfielStatusLiveData = MutableLiveData<Resource<ProfileCompleteStatus>>()


    var _completeProfielStatusLiveData: LiveData<Resource<ProfileCompleteStatus>> = completeProfielStatusLiveData

     fun logIn(email: String, password: String,rememberMe:Boolean) {


        viewModelScope.launch {
            withContext(Dispatchers.IO) {
              val result =  authRepository.logIn(email, password,rememberMe)
                logInLiveData.postValue(result)
            }
        }

    }



    fun completeProfile() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = completeProfileRepository.completeProfile(pref.userID())
                completeProfielStatusLiveData.postValue(result)
            }
        }
    }

}