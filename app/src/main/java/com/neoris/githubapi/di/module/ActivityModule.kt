package com.neoris.githubapi.di.module

import com.neoris.githubapi.presentation.ui.activities.UsersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): UsersActivity


}