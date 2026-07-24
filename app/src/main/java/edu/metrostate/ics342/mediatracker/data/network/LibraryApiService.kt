package edu.metrostate.ics342.mediatracker.data.network

import edu.metrostate.ics342.mediatracker.data.model.Favorite
import edu.metrostate.ics342.mediatracker.data.model.HttpErrorCodeMessage
import edu.metrostate.ics342.mediatracker.data.model.LibraryItem
import edu.metrostate.ics342.mediatracker.data.model.Media
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LibraryApiService {

    @GET("library/{mediaId}")
    suspend fun getMedia(
        @Path("mediaId") mediaId: Int
    ): Response<LibraryItem>

    @POST("library")
    suspend fun addMedia(
        @Query("mediaId") mediaId: Int,
        @Query("status") status: String,
    ): Response<LibraryItem>

    @DELETE("library/{mediaId}")
    suspend fun removeFromLib(
        @Path("mediaId") mediaId: Int
    ): Response<HttpErrorCodeMessage?>

    @GET("library")
    suspend fun getLibrary(
        @Query("status") genre: String? = null,
        @Query("limit") limit: Int = 20,
        @Query("after") after: String? = null
    ): Response<List<Media>>

    @POST("favorites")
    suspend fun save(
        mediaId: Int
    ): Response<Favorite>
}