package com.andrewkingmarshall.stackoverflowleaderboard.network.service

import com.andrewkingmarshall.stackoverflowleaderboard.network.responses.UserSearchResponse
import retrofit2.Retrofit
import javax.inject.Inject

class StackExchangeApiService @Inject constructor(retrofit: Retrofit) {

    private val apiServiceInterface by lazy {
        retrofit.create(StackExchangeApiServiceInterface::class.java)
    }

    suspend fun getUsers() : UserSearchResponse {
        return apiServiceInterface.getUsers()
    }
}