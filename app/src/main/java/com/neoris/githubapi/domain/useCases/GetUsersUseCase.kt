package com.neoris.githubapi.domain.useCases

import com.neoris.githubapi.domain.models.User
import com.neoris.githubapi.domain.repositoryAbstractions.GitHubRepository
import com.neoris.githubapi.domain.useCases.base.SingleUseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val gitHubRepository: GitHubRepository) :
    SingleUseCase<List<User>>() {

    private lateinit var token: String

    fun setToken(token: String) {
        this.token = token
    }

    override fun buildUseCaseObservable(): Observable<List<User>> =
        when {
            this.token.isBlank() -> Observable.error(Throwable("Invalid token"))
            else -> this.gitHubRepository.getUser(this.token)
        }


}