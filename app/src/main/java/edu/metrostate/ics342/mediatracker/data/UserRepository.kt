package edu.metrostate.ics342.mediatracker.data

import edu.metrostate.ics342.mediatracker.data.network.CreateUserResponse

interface UserRepository {
    suspend fun register(
        email: String,
        password: String,
        username: String,
        displayName: String
    ): RegisterResult

    suspend fun login(
        email: String,
        password: String,
    ): LoginResult
}

sealed interface RegisterResult {
    data object Success : RegisterResult
    data object Conflict : RegisterResult
    data object NetworkError : RegisterResult
    data object UnknownError : RegisterResult
}

sealed interface LoginResult {
    data class Success(
        val accessToken: String,
        val refreshToken: String,
        val user: CreateUserResponse
    ) : LoginResult
    data object Conflict : LoginResult
    data object NetworkError : LoginResult
    data object UnknownError : LoginResult
}