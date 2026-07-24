package edu.metrostate.ics342.mediatracker.data.model

import kotlinx.serialization.Serializable

@Serializable
data class HttpErrorCodeMessage (
    val code: String,
    val message: String
)