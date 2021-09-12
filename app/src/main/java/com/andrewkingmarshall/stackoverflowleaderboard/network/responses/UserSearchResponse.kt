package com.andrewkingmarshall.stackoverflowleaderboard.network.responses

import com.andrewkingmarshall.stackoverflowleaderboard.network.dtos.UserDto
import com.google.gson.annotations.SerializedName

data class UserSearchResponse(
    @SerializedName("items") val users: List<UserDto>
)
