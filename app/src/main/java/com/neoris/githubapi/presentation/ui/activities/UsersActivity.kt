package com.neoris.githubapi.presentation.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.neoris.githubapi.R
import com.neoris.githubapi.presentation.ui.adapters.UsersAdapter
import com.neoris.githubapi.presentation.ui.viewmodels.UsersViewModel
import com.neoris.githubapi.presentation.ui.viewmodels.UsersViewModelFactory
import com.neoris.githubapi.presentation.ui.viewmodels.UsersViewModelState
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class UsersActivity : AppCompatActivity() {

    @Inject
    lateinit var usersViewModelFactory: UsersViewModelFactory

    private val usersViewModel: UsersViewModel by lazy {
        ViewModelProvider(this, usersViewModelFactory).get(UsersViewModel::class.java)
    }

    private val usersAdapter: UsersAdapter by lazy {
        UsersAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        this.initAdapters()

        this.usersViewModel.getUsers()
        this.initObserveViewModel()
    }

    private fun initAdapters() {
        this.rvUsers?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        this.rvUsers?.adapter = this.usersAdapter
    }

    private fun initObserveViewModel() {
        this.usersViewModel.userViewModelState.observe(this, Observer { state ->
            when (state) {
                is UsersViewModelState.Users -> {
                    this.usersAdapter.updateUsers(state.users)
                }
                is UsersViewModelState.ProgressVisibility -> {
                    this.loading.visibility = state.visibility
                    this.rvUsers.visibility =
                        if (state.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                }
                is UsersViewModelState.ErrorState -> {
                    Snackbar.make(this.parentLayout, state.error, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }

}