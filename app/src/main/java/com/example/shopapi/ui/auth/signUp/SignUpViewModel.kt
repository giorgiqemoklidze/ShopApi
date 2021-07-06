package com.example.shopapi.ui.auth.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapi.model.SignUp
import com.example.shopapi.network.Resource
import com.example.shopapi.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

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