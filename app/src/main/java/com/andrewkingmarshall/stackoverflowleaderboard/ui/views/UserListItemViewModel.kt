package com.andrewkingmarshall.stackoverflowleaderboard.ui.views

import com.andrewkingmarshall.stackoverflowleaderboard.database.entities.User

class UserListItemViewModel(val user: User) {

    fun getName() = user.displayName

}