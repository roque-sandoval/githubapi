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
        this.getUsersUseCase.setToken("token 4994260c19b75959d5fc86add7032790073deaac")
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