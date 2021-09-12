package com.andrewkingmarshall.stackoverflowleaderboard.enums

import androidx.room.TypeConverter

enum class UserType(val serverValue: String) {
    UNREGISTERED("unregistered"),
    REGISTERED("registered"),
    MODERATOR("moderator"),
    TEAM_ADMIN("team_admin"),
    DOES_NOT_EXIST("does_not_exist"),
}

class UserTypeConverters {
    @TypeConverter
    fun toUser(serverValue: String) =
        when (serverValue) {
            UserType.UNREGISTERED.serverValue -> UserType.UNREGISTERED
            UserType.REGISTERED.serverValue -> UserType.REGISTERED
            UserType.MODERATOR.serverValue -> UserType.MODERATOR
            UserType.TEAM_ADMIN.serverValue -> UserType.TEAM_ADMIN
            UserType.DOES_NOT_EXIST.serverValue -> UserType.DOES_NOT_EXIST
            else -> UserType.DOES_NOT_EXIST
        }

    @TypeConverter
    fun fromUser(value: UserType) = value.serverValue

    fun isValid(serverValue: String): Boolean {
        UserType.values().forEach {
            if (it.serverValue == serverValue) {
                return true
            }
        }

        return false
    }
}
