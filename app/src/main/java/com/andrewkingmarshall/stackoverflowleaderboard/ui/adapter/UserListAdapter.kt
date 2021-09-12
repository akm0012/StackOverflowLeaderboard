package com.andrewkingmarshall.stackoverflowleaderboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andrewkingmarshall.stackoverflowleaderboard.database.entities.User
import com.andrewkingmarshall.stackoverflowleaderboard.databinding.ContainerUserItemBinding

class UserListAdapter : ListAdapter<User, UserListAdapter.ViewHolder>(UserDiffCallback()) {

    fun interface OnUserClickedListener {
        fun onUserClicked(user: User)
    }

    private var onUserClickedListener: OnUserClickedListener? = null

    fun setOnUserClickedListener(onUserClickedListener: OnUserClickedListener?) {
        this.onUserClickedListener = onUserClickedListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ContainerUserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onUserClickedListener)
    }

    class ViewHolder(
        private val binding: ContainerUserItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User, userClickedListener: OnUserClickedListener?) {
            binding.userItem.setUser(user)
            userClickedListener?.let { listener ->
                binding.userItem.setOnClickListener { listener.onUserClicked(user) }
            }
        }
    }
}

private class UserDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(
        oldItem: User,
        newItem: User
    ): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(
        oldItem: User,
        newItem: User
    ): Boolean {
        return oldItem == newItem
    }
}