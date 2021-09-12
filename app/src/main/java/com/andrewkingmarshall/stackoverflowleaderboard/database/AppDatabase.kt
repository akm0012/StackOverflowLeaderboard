package com.andrewkingmarshall.stackoverflowleaderboard.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andrewkingmarshall.stackoverflowleaderboard.database.dao.UserDao
import com.andrewkingmarshall.stackoverflowleaderboard.database.entities.User

@Database(
    entities = [
        User::class,
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}