package com.neoris.githubapi.presentation.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.neoris.githubapi.data.services.local.AppPreferences
import com.neoris.githubapi.domain.useCases.GetUsersUseCase
import javax.inject.Inject

class UsersViewModelFactory @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val appPreferences: AppPreferences
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(
                GetUsersUseCase::class.java,
                AppPreferences::class.java
            )
            .newInstance(
                this.getUsersUseCase,
                this.appPreferences
            )
    }
}