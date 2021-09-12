package com.andrewkingmarshall.stackoverflowleaderboard.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.andrewkingmarshall.stackoverflowleaderboard.repository.UserRepository
import com.andrewkingmarshall.stackoverflowleaderboard.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    init {
       refreshUsers()
    }

    val showError = SingleLiveEvent<String>()

    val users = userRepository.userFlow.asLiveData()

    private fun refreshUsers() {
        viewModelScope.launch {
            try {
                userRepository.refreshUsers()
            } catch (cause: Exception) {
                showError.value = cause.localizedMessage
            }
        }
    }

}