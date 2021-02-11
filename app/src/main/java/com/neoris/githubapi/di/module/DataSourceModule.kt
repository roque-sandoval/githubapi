package com.neoris.githubapi.di.module

import com.neoris.githubapi.data.datasourceImplementations.api.GitHubApiDataSourceImpl
import com.neoris.githubapi.data.exceptions.ApiResponseHandler
import com.neoris.githubapi.data.reposotoryImplementations.GitHubRepositoryImpl
import com.neoris.githubapi.data.services.api.GitHubService
import com.neoris.githubapi.domain.dataSourceAbstractions.GitHubDataSource
import com.neoris.githubapi.domain.repositoryAbstractions.GitHubRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideGitHubService(retrofit: Retrofit): GitHubService =
        retrofit.create(GitHubService::class.java)


    @Provides
    @Singleton
    fun provideGitHubDataSource(gitHubApiDataSourceImpl: GitHubApiDataSourceImpl): GitHubDataSource =
        gitHubApiDataSourceImpl

}