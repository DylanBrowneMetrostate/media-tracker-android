package edu.metrostate.ics342.mediatracker.data

import edu.metrostate.ics342.mediatracker.data.model.UserProfile
import edu.metrostate.ics342.mediatracker.data.network.CreateUserResponse

interface SessionRepository {
    suspend fun saveSession(accessToken: String, refreshToken: String, user: CreateUserResponse)
    suspend fun getAccessToken(): String?
    suspend fun getRefreshToken(): String?
    suspend fun getUser(): UserProfile?
    suspend fun clearSession()
}
