package com.andrewkingmarshall.stackoverflowleaderboard.network.dtos

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("account_id") val accountId: Long,
    @SerializedName("is_employee") val isEmployee: Boolean,
    @SerializedName("last_modified_date") val lastModifiedDateSeconds: Long,
    @SerializedName("last_access_date") val lastAccessDateSeconds: Long,
    @SerializedName("reputation_change_year") val reputationChangeYear: Long,
    @SerializedName("reputation_change_quarter") val reputationChangeQuarter: Long,
    @SerializedName("reputation_change_month") val reputationChangeMonth: Long,
    @SerializedName("reputation_change_week") val reputationChangeWeek: Long,
    @SerializedName("reputation_change_day") val reputationChangeDay: Long,
    val reputation: Long,
    @SerializedName("creation_date") val creationDateSec: Long,
    @SerializedName("user_type") val userType: String,
    @SerializedName("user_id") val userId: Long,
    val location: String?,
    @SerializedName("website_url") val websiteUrl: String,
    val link: String,
    @SerializedName("profile_image") val profileImage: String?,
    @SerializedName("display_name") val displayName: String,
    @SerializedName("badge_counts") val badgeCounts: BadgeCountDto,
)


