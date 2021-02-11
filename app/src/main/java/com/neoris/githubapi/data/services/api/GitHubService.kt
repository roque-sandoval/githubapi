package com.neoris.githubapi.data.services.api

import com.neoris.githubapi.AppConstants
import com.neoris.githubapi.domain.models.responseObjects.UserResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface GitHubService {

    @GET(AppConstants.API_USERS)
    fun getUser(@Header("Authorization") token: String): Observable<Response<List<UserResponse>>>
}