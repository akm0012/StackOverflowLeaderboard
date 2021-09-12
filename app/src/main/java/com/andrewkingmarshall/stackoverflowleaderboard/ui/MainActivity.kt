package com.andrewkingmarshall.stackoverflowleaderboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.andrewkingmarshall.stackoverflowleaderboard.R
import com.andrewkingmarshall.stackoverflowleaderboard.repository.UserRepository
import com.andrewkingmarshall.stackoverflowleaderboard.viewmodels.UserListViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import com.andrewkingmarshall.stackoverflowleaderboard.extensions.toast
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserListViewModel

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(UserListViewModel::class.java)

        viewModel.users.observe(this, {
            Timber.d("Users: $it")
        })

        viewModel.showError.observe(this, { it?.toast(this) })

        findViewById<View>(R.id.test).setOnClickListener {

            lifecycleScope.launch {
                userRepository.refreshUsers()
            }

        }
    }
}