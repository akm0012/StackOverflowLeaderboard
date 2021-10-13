package com.andrewkingmarshall.stackoverflowleaderboard.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.andrewkingmarshall.stackoverflowleaderboard.R
import com.andrewkingmarshall.stackoverflowleaderboard.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import org.joda.time.DateTime
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userRepository: UserRepository,
) : ViewModel() {

    fun getUserDomainModelLiveData(userId: Long): LiveData<UserDetailDomainModel> {
        return userRepository.getUserByIdFlow(userId)
            .map {

                val memberSince = DateTime(it.creationDateSec * 1000).toString("MMMM d, yyyy")

                UserDetailDomainModel(
                    it.profileImageUrl,
                    it.displayName,
                    context.getString(R.string.total_reputation, it.reputation),
                    it.goldBadgeCount.toString(),
                    it.silverBadgeCount.toString(),
                    it.bronzeBadgeCount.toString(),
                    context.getString(R.string.member_since, memberSince),
                    context.getString(
                        R.string.member_type_and_location,
                        it.userLocation,
                        context.getString(it.userType.readableResourceId)
                    )
                )
            }
            .asLiveData()
    }

    data class UserDetailDomainModel(
        val userProfilePicUrl: String?,
        val userName: String,
        val totalReputationDisplayString: String,
        val goldMedalCount: String,
        val silverMedalCount: String,
        val bronzeMedalCount: String,
        val memberSince: String,
        val userTypeAndLocation: String,
    )

}