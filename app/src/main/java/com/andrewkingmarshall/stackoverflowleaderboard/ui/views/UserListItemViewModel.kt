package com.andrewkingmarshall.stackoverflowleaderboard.ui.views

import com.andrewkingmarshall.stackoverflowleaderboard.database.entities.User

/**
 * A very simple View Model, though this is where more complicated business view logic could live.
 */
class UserListItemViewModel(val user: User) {

    fun getName() = user.displayName

    fun getTotalReputation() = user.reputation.toString()

    fun getGoldMedalCount() = user.goldBadgeCount.toString()

    fun getSilverMedalCount() = user.silverBadgeCount.toString()

    fun getBronzeMedalCount() = user.bronzeBadgeCount.toString()

    fun getProfilePicUrl() = user.profileImageUrl
}