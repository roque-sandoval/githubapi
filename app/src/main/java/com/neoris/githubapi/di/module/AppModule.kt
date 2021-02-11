package com.neoris.githubapi.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import com.neoris.githubapi.data.services.local.AppPreferences
import com.neoris.githubapi.presentation.utils.ResourceProvider
import com.neoris.githubapi.presentation.utils.Utils
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppUtil(app: Application): Utils = Utils(app)


    @Provides
    @Singleton
    fun provideAppPreferences(app: Application): AppPreferences =
        AppPreferences(app)


    @Provides
    @Singleton
    fun provideResource(app: Application): ResourceProvider = ResourceProvider(app)

}
