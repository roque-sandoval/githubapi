package com.neoris.githubapi.di.module

import com.neoris.githubapi.data.reposotoryImplementations.GitHubRepositoryImpl
import com.neoris.githubapi.domain.repositoryAbstractions.GitHubRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideGitHubRepository(gitHubRepositoryImpl: GitHubRepositoryImpl): GitHubRepository =
        gitHubRepositoryImpl

}