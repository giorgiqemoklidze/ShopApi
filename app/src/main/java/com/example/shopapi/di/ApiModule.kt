package com.example.shopapi.di

import com.example.shopapi.network.ApiService
import com.example.shopapi.repository.LoginRepository
import com.example.shopapi.repository.LoginRepositoryImplement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    companion object{

        const val BASE_URL = "https://ktorhighsteaks.herokuapp.com/"

    }


    @Provides
    @Singleton
    fun login() =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideLoginRepostory(apiService: ApiService):LoginRepository = LoginRepositoryImplement(apiService)

}