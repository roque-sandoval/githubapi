package com.neoris.githubapi.presentation.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neoris.githubapi.R
import com.neoris.githubapi.domain.models.User
import kotlinx.android.synthetic.main.user_item.view.*

class UsersAdapter(val context: Context) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    var users: MutableList<User> = mutableListOf()

    fun updateUsers(users: List<User>) {
        this.users.clear()
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(this.context).inflate(
            R.layout.user_item, parent, false
        )
    )

    override fun getItemCount(): Int = this.users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(this.users[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(user: User) =
            with(this.itemView) {
                tvUserName.text = user.login
            }
    }
}