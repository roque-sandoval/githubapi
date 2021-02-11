package com.neoris.githubapi.presentation.ui.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.neoris.githubapi.data.services.local.AppPreferences
import com.neoris.githubapi.domain.models.User
import com.neoris.githubapi.domain.useCases.GetUsersUseCase
import com.neoris.githubapi.presentation.ui.viewmodels.base.ViewModelBase

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class UsersViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val appPreferences: AppPreferences
) : ViewModelBase() {

    val userViewModelState = MutableLiveData<UsersViewModelState>()

    fun getUsers() {
        this.userViewModelState.value = UsersViewModelState.ProgressVisibility(View.VISIBLE)
        this.getUsersUseCase.setToken("token 0aa9af9bab06a1ffa228827c61ab8716c92561d3")
        this.getUsersUseCase.execute(
            onSuccess = ::handleUsers,
            onError = ::handleError
        )
    }

    private fun handleUsers(users: List<User>) {
        this.userViewModelState.value = UsersViewModelState.ProgressVisibility(View.GONE)
        this.userViewModelState.value = UsersViewModelState.Users(users)
    }


    override fun defaultError(error: Throwable) {
        this.userViewModelState.value = UsersViewModelState.ProgressVisibility(View.GONE)
        this.userViewModelState.value = UsersViewModelState.ErrorState(error.localizedMessage)
    }
}