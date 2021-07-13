package com.example.shopapi.ui.home

import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapi.model.Posts
import com.example.shopapi.network.Resource
import com.example.shopapi.repository.posts.GetPostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.http2.Http2Reader
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postRepo: GetPostsRepository) : ViewModel() {


    private val _postLiveData = MutableLiveData<Resource<List<Posts>>>()
    val postLiveData: LiveData<Resource<List<Posts>>> = _postLiveData


    fun getPost() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val posts = postRepo.getPost()
                d("postebi","${posts.data}")
                _postLiveData.postValue(posts)
            }
        }

    }

}