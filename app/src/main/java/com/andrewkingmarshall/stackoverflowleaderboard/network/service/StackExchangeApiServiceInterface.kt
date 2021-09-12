package com.andrewkingmarshall.stackoverflowleaderboard.network.service

import com.andrewkingmarshall.stackoverflowleaderboard.network.responses.UserSearchResponse
import retrofit2.http.GET

interface StackExchangeApiServiceInterface {

    /**
     * Note:    It looks like the only site this endpoint takes, is 'stackoverflow' so it's ok to
     *          hard code it here as it would never change.
     *
     * @return A list of Stack Overflow Users
     */
    @GET("users?site=stackoverflow")
    suspend fun getUsers(): UserSearchResponse

}