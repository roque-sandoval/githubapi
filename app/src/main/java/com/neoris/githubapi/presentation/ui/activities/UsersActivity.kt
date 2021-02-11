package com.neoris.githubapi.presentation.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.neoris.githubapi.R
import com.neoris.githubapi.presentation.ui.viewmodels.UsersViewModel
import com.neoris.githubapi.presentation.ui.viewmodels.UsersViewModelFactory
import com.neoris.githubapi.presentation.ui.viewmodels.UsersViewModelState
import dagger.android.AndroidInjection
import javax.inject.Inject

class UsersActivity : AppCompatActivity() {

    @Inject
    lateinit var usersViewModelFactory: UsersViewModelFactory

    private val usersViewModel: UsersViewModel by lazy {
        ViewModelProvider(this, usersViewModelFactory).get(UsersViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        this.usersViewModel.getUsers()
        this.initObserveViewModel()
    }

    private fun initObserveViewModel() {
        this.usersViewModel.userViewModelState.observe(this, Observer { state ->
            when (state) {
                is UsersViewModelState.Users -> {
                    state.users.size
                }
                is UsersViewModelState.ProgressVisibility -> {

                }
                is UsersViewModelState.ErrorState -> {

                }
            }
        })
    }

}