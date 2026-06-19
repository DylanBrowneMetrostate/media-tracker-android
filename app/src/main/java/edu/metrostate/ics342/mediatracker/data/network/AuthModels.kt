package edu.metrostate.ics342.mediatracker.data.network

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    val email: String,
    val password: String,
    val username: String,
    val displayName: String,
    val clientId: String,
    val clientSecret: String
)

@Serializable
data class TokenRequest(
    val grantType: String,
    val email: String? = null,
    val password: String? = null,
    val refreshToken: String? = null,
    val clientId: String,
    val clientSecret: String
)

@Serializable
data class CreateUserResponse(
    val id: String? = null,
    val email: String? = null,
    val password: String? = null,
    val username: String? = null,
    val displayName: String? = null,
    val bio: String? = null,
    val avatarUrl: String? = null,
    val followerCount: Int? = null,
    val followingCount: Int? = null,
    val isFollowing: Boolean? = null,
    // TODO Fix createdAt
    val createdAt: Long? = null,
    val message: String? = null
)

@Serializable
data class TokenResponse(
    val accessToken: String? = null,
    val refreshToken: String? = null,
    val user: CreateUserResponse? = null,
    val message: String? = null
)