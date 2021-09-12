package com.andrewkingmarshall.stackoverflowleaderboard.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.andrewkingmarshall.stackoverflowleaderboard.enums.UserType
import com.andrewkingmarshall.stackoverflowleaderboard.enums.UserTypeConverters
import com.andrewkingmarshall.stackoverflowleaderboard.network.dtos.UserDto
import java.io.IOException

@Entity
data class User(
    @PrimaryKey val userId: Long,

    val displayName: String,

    val profileImageUrl: String?,

    val goldBadgeCount: Int,

    val silverBadgeCount: Int,

    val bronzeBadgeCount: Int,

    val userLocation: String?,

    val reputation: Long,

    val creationDateSec: Long,

    @TypeConverters(UserTypeConverters::class)
    val userType: UserType,
) {
    constructor(userDto: UserDto) : this(
        userId = userDto.userId,
        displayName = userDto.displayName,
        profileImageUrl = userDto.profileImage,
        goldBadgeCount = userDto.badgeCounts.goldMedalCount,
        silverBadgeCount = userDto.badgeCounts.silverMedalCount,
        bronzeBadgeCount = userDto.badgeCounts.bronzeMedalCount,
        userLocation = userDto.location,
        reputation = userDto.reputation,
        creationDateSec = userDto.creationDateSec,

        // Todo: play with this
        userType = if (UserTypeConverters().isValid(userDto.userType)) {
            UserTypeConverters().toUser(userDto.userType)
        } else {
            throw EnumNotSupportedException("Unsupported User Type: ${userDto.userType}")
        }
    )

}

class EnumNotSupportedException(private val _message: String? = null) : IOException(_message)