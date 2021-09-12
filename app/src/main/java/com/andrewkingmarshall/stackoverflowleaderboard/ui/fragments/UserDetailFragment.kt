package com.andrewkingmarshall.stackoverflowleaderboard.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.andrewkingmarshall.stackoverflowleaderboard.R
import com.andrewkingmarshall.stackoverflowleaderboard.database.entities.User
import com.andrewkingmarshall.stackoverflowleaderboard.databinding.FragmentUserDetailBinding
import com.andrewkingmarshall.stackoverflowleaderboard.viewmodels.UserDetailViewModel
import com.andrewkingmarshall.stackoverflowleaderboard.viewmodels.UserListViewModel
import com.bumptech.glide.Glide

class UserDetailFragment :
    BaseFragment<FragmentUserDetailBinding>(FragmentUserDetailBinding::inflate) {

    private val args: UserDetailFragmentArgs by navArgs()

    private lateinit var viewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(UserDetailViewModel::class.java)
    }

    override fun setup(view: View) {

        val userId = args.userId

        viewModel.getUserDomainModelLiveData(userId).observe(viewLifecycleOwner, { setUserViews(it) })
    }

    private fun setUserViews(userDomainModel: UserDetailViewModel.UserDetailDomainModel) {

        binding.apply {
            userNameTextView.text = userDomainModel.userName
            userType.text = userDomainModel.userType
            totalReputationTextView.text = userDomainModel.totalReputationDisplayString
            goldMedalCount.text = userDomainModel.goldMedalCount
            silverMedalCount.text = userDomainModel.silverMedalCount
            bronzeMedalCount.text = userDomainModel.bronzeMedalCount
            memberSinceTextView.text = userDomainModel.memberSince

            Glide.with(this@UserDetailFragment)
                .load(userDomainModel.userProfilePicUrl)
                .into(userProfileImageView)
        }
    }
}