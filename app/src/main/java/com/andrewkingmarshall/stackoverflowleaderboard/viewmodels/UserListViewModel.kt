package com.andrewkingmarshall.stackoverflowleaderboard.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.andrewkingmarshall.stackoverflowleaderboard.repository.UserRepository
import com.andrewkingmarshall.stackoverflowleaderboard.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

const val MIN_PULL_TO_REFRESH_ANIMATION_TIME = 1000L

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    init {
        refreshUsers()
    }

    val showLoadingEvent: SingleLiveEvent<Boolean> = SingleLiveEvent()

    val showError = SingleLiveEvent<String>()

    val users = userRepository.userFlow.asLiveData()

    private fun refreshUsers() {
        viewModelScope.launch {
            try {
                userRepository.refreshUsers()

                // Always show the loading indicator for some small bit of time, even if the call finishes quickly
                delay(MIN_PULL_TO_REFRESH_ANIMATION_TIME)
                showLoadingEvent.value = false

            } catch (cause: Exception) {
                showError.value = cause.localizedMessage
            }
        }
    }

    fun onPullToRefresh() {
        refreshUsers()
    }

}