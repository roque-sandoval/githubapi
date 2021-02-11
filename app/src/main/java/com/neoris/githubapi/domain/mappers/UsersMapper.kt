package com.neoris.githubapi.domain.mappers

import com.neoris.githubapi.domain.models.User
import com.neoris.githubapi.domain.models.responseObjects.UserResponse
import javax.inject.Inject

class UsersMapper @Inject constructor() {

    fun mapFromApi(userResponse: UserResponse): User =
        User(
            userResponse.id ?: 0,
            userResponse.login ?: ""
        )

}