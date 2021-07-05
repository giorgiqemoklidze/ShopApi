package com.example.shopapi.auth.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapi.model.SignUp
import com.example.shopapi.network.Resource
import com.example.shopapi.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpViewModel @Inject constructor(val authRepository: AuthRepository) : ViewModel() {

    private var signUpLiveData = MutableLiveData<Resource<SignUp>>()

    var _signUpLiveData: LiveData<Resource<SignUp>> = signUpLiveData

    fun signUp(email: String, fullname: String, password: String) {


        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = authRepository.signUp(email, fullname, password)
                signUpLiveData.postValue(result)
            }
        }

    }

}