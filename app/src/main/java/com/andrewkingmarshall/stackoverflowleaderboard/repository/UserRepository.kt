package com.andrewkingmarshall.stackoverflowleaderboard.repository

import com.andrewkingmarshall.stackoverflowleaderboard.database.dao.UserDao
import com.andrewkingmarshall.stackoverflowleaderboard.database.entities.EnumNotSupportedException
import com.andrewkingmarshall.stackoverflowleaderboard.database.entities.User
import com.andrewkingmarshall.stackoverflowleaderboard.network.service.StackExchangeApiService
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: StackExchangeApiService,
    private val userDao: UserDao,
) {

    val usersFlow = userDao.getUsers()

    fun getUserByIdFlow(userId: Long): Flow<User> {
        return userDao.getUser(userId)
    }

    suspend fun refreshUsers() {
        try {
            val userDtos = apiService.getUsers().users

            val usersToSave = ArrayList<User>()

            userDtos.forEach {
                try {
                    usersToSave.add(User(it))
                } catch (enumError: EnumNotSupportedException) {
                    Timber.w(enumError, "Unsupported Enum found.")
                }
            }

            userDao.insertUsers(usersToSave)

        } catch (cause: Exception) {
            Timber.d(cause, "Unable to refresh Users: ${cause.localizedMessage}")
            throw cause
        }
    }

}