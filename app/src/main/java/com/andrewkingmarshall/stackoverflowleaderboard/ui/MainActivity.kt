package com.andrewkingmarshall.stackoverflowleaderboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.andrewkingmarshall.stackoverflowleaderboard.databinding.ActivityMainBinding
import com.andrewkingmarshall.stackoverflowleaderboard.repository.UserRepository
import com.andrewkingmarshall.stackoverflowleaderboard.viewmodels.UserListViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.andrewkingmarshall.stackoverflowleaderboard.extensions.toast
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}