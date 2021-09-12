package com.andrewkingmarshall.stackoverflowleaderboard.network.dtos

import com.google.gson.annotations.SerializedName

data class BadgeCountDto(
    @SerializedName("bronze") val bronzeMedalCount: Int,
    @SerializedName("silver") val silverMedalCount: Int,
    @SerializedName("gold") val goldMedalCount: Int,
)
