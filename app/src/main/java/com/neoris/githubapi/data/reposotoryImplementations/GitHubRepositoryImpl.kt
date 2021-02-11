package com.neoris.githubapi.data.reposotoryImplementations

import com.neoris.githubapi.domain.dataSourceAbstractions.GitHubDataSource
import com.neoris.githubapi.domain.models.User
import com.neoris.githubapi.domain.repositoryAbstractions.GitHubRepository
import io.reactivex.Observable
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(private val gitHubDataSource: GitHubDataSource) :
    GitHubRepository {

    override fun getUser(token: String): Observable<List<User>> =
        this.gitHubDataSource.getUser(token)
}