package com.andrewkingmarshall.stackoverflowleaderboard.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.andrewkingmarshall.stackoverflowleaderboard.R
import com.andrewkingmarshall.stackoverflowleaderboard.databinding.FragmentUserListBinding
import com.andrewkingmarshall.stackoverflowleaderboard.extensions.toast
import com.andrewkingmarshall.stackoverflowleaderboard.ui.adapter.UserListAdapter
import com.andrewkingmarshall.stackoverflowleaderboard.viewmodels.UserListViewModel

class UserListFragment : BaseFragment<FragmentUserListBinding>(FragmentUserListBinding::inflate) {

    private lateinit var navController: NavController

    private lateinit var viewModel: UserListViewModel

    private val userListAdapter = UserListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(UserListViewModel::class.java)
    }

    override fun setup(view: View) {
        navController = Navigation.findNavController(view)

        viewModel.showError.observe(viewLifecycleOwner, { it.toast(requireContext()) })

        setUpUserList()
    }

    private fun setUpUserList() {

        // Set up pull to refresh
        binding.swipeRefreshLayout.apply {
            setColorSchemeColors(
                ContextCompat.getColor(requireContext(), R.color.purple_700),
                ContextCompat.getColor(requireContext(), R.color.teal_200)
            )
            setOnRefreshListener { viewModel.onPullToRefresh() }
        }

        // Set up adapter
        binding.recyclerView.adapter = userListAdapter.apply {
            setOnUserClickedListener { it.displayName.toast(requireContext()) }
        }

        // Listen to refresh the user data
        viewModel.users.observe(viewLifecycleOwner, { userListAdapter.submitList(it) })

        // Listen for when we should stop showing the pull to refresh indicator
        viewModel.showLoadingEvent.observe(
            viewLifecycleOwner,
            { binding.swipeRefreshLayout.isRefreshing = it })
    }
}