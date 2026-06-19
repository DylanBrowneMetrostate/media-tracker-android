package edu.metrostate.ics342.mediatracker.data.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {

    @POST("users")
    suspend fun createUser(@Body body: CreateUserRequest): Response<CreateUserResponse>


    @POST("tokens")
    suspend fun login(@Body request: TokenRequest): Response<TokenResponse>
}
