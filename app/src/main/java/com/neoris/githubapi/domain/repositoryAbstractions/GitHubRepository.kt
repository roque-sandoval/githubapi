package com.neoris.githubapi.domain.repositoryAbstractions

import com.neoris.githubapi.domain.models.User
import io.reactivex.Observable

interface GitHubRepository {

    fun getUser(token: String): Observable<List<User>>

}