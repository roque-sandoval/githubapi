package com.neoris.githubapi.presentation.ui.viewmodels

import com.neoris.githubapi.domain.models.User

sealed class UsersViewModelState {

    data class ProgressVisibility(val visibility: Int) : UsersViewModelState()

    data class Users(val users: List<User>) : UsersViewModelState()

    data class ErrorState(val error: String) : UsersViewModelState()


}
