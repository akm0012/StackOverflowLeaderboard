package com.andrewkingmarshall.stackoverflowleaderboard.inject

import android.content.Context
import androidx.room.Room
import com.andrewkingmarshall.stackoverflowleaderboard.database.AppDatabase
import com.andrewkingmarshall.stackoverflowleaderboard.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "StackOverflowLeaderBoard-Database"
        ).build()
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }

}