package edu.metrostate.ics342.mediatracker.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Favorite (
    val userId: String? = null,
    val mediaId: Int? = null,
    val createdAt: String? = null,
    val media: Media? = null,

    val code: String? = null,
    val message: String? = null
)