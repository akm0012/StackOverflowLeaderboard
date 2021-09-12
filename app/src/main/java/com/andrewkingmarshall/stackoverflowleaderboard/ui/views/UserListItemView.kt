package com.andrewkingmarshall.stackoverflowleaderboard.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.andrewkingmarshall.stackoverflowleaderboard.database.entities.User
import com.andrewkingmarshall.stackoverflowleaderboard.databinding.CompoundViewUserItemBinding
import com.bumptech.glide.Glide

class UserListItemView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private var binding: CompoundViewUserItemBinding =
        CompoundViewUserItemBinding.inflate(LayoutInflater.from(context), this)

    private fun resetView() {
        binding.apply {
            nameTextView.text = ""
            totalReputationTextView.text = ""
            goldMedalCount.text = ""
            silverMedalCount.text = ""
            bronzeMedalCount.text = ""
            profileImageView.setImageDrawable(null)
        }
    }

    fun setUser(user: User) {
        resetView()

        val viewModel = UserListItemViewModel(user)

        binding.apply {
            nameTextView.text = viewModel.getName()
            totalReputationTextView.text = viewModel.getTotalReputation()
            goldMedalCount.text = viewModel.getGoldMedalCount()
            silverMedalCount.text = viewModel.getSilverMedalCount()
            bronzeMedalCount.text = viewModel.getBronzeMedalCount()

            Glide.with(context)
                .load(viewModel.getProfilePicUrl())
                .into(profileImageView)
        }
    }
}