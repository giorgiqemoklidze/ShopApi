package com.example.shopapi.di

import android.content.Context
import com.example.shopapi.BuildConfig
import com.example.shopapi.network.AuthService
import com.example.shopapi.network.PostService
import com.example.shopapi.repository.AuthRepository
import com.example.shopapi.repository.AuthRepositoryImplement
import com.example.shopapi.repository.posts.GetPostsRepository
import com.example.shopapi.repository.posts.GetPostsRepositoryImpl
import com.example.shopapi.user_data.UserPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    companion object {

        const val BASE_URL = "https://ktorhighsteaks.herokuapp.com/"

    }

    private fun okHttpClient(userPreference: UserPreference): OkHttpClient {

        val builder = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            chain.request().url

            val request = chain.request().newBuilder()

            val response = chain.proceed(request.build())

            val token = userPreference.token()

            if (!token.isNullOrBlank()) {
                request.addHeader("Authorization", "Bearer $token")
            }

            response
        })

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }

        return builder.build()
    }


    @Provides
    @Singleton
    fun login(
        @ApplicationContext context: Context,
        userPreference: UserPreference
    ) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//        .client(interceptorClient(userPreference))
            .build()
            .create(AuthService::class.java)

    @Provides
    @Singleton
    fun provideLoginRepostory(
        authService: AuthService,
        userPreference: UserPreference
    ): AuthRepository = AuthRepositoryImplement(authService, userPreference)


    @Provides
    @Singleton
    fun getPostService(): PostService =
        Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(PostService::class.java)


    @Provides
    @Singleton
    fun getPostRepo(postsService: PostService): GetPostsRepository =
        GetPostsRepositoryImpl(postsService)

}