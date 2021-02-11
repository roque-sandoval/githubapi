package com.neoris.githubapi.data.datasourceImplementations.api


import com.neoris.githubapi.data.exceptions.ApiResponseHandler
import com.neoris.githubapi.data.services.api.GitHubService
import com.neoris.githubapi.domain.dataSourceAbstractions.GitHubDataSource
import com.neoris.githubapi.domain.mappers.UsersMapper
import com.neoris.githubapi.domain.models.User
import io.reactivex.Observable
import javax.inject.Inject

class GitHubApiDataSourceImpl @Inject constructor(
    private val gitHubService: GitHubService,
    private val apiResponseHandler: ApiResponseHandler,
    private val usersMapper: UsersMapper
) : GitHubDataSource {

    override fun getUser(token: String): Observable<List<User>> =
        this.gitHubService.getUser(
            token
        ).flatMap { response ->
            this.apiResponseHandler.handle(response)
        }.flatMapIterable { it }
            .map { usersApiResponseObject ->
                this.usersMapper.mapFromApi(usersApiResponseObject)
            }.toList()
            .toObservable()

}