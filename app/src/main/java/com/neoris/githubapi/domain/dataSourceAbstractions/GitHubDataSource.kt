package com.neoris.githubapi.domain.dataSourceAbstractions

import com.neoris.githubapi.domain.models.User
import io.reactivex.Observable

interface GitHubDataSource {

    fun getUser(token: String): Observable<List<User>>

}