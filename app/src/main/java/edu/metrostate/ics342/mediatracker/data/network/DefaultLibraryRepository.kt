package edu.metrostate.ics342.mediatracker.data.network

import edu.metrostate.ics342.mediatracker.data.SessionRepository
import edu.metrostate.ics342.mediatracker.data.model.Favorite
import edu.metrostate.ics342.mediatracker.data.model.HttpErrorCodeMessage
import edu.metrostate.ics342.mediatracker.data.model.LibraryItem

class DefaultLibraryRepository(sessionRepository: SessionRepository) {
    private val api = RetrofitInstance.libraryApiService(sessionRepository)

    suspend fun getFromLib(mediaId: Int): LibraryResponse {
        val response = api.getMedia(mediaId)
        return when (response.code()) {
            200     -> LibraryResponse.Success(response.body()!!)
            else    -> LibraryResponse.Error(
                response.code(),
                response.body()?.code,
                response.body()?.message
            )
        }
    }

    suspend fun addTo(mediaId: Int, status: String): LibraryResponse {
        val response = api.addMedia(mediaId, status)
        return when (response.code()) {
            201     -> LibraryResponse.Success(response.body()!!)
            else    -> LibraryResponse.Error(
                response.code(),
                response.body()?.code,
                response.body()?.message
                )
        }
    }

    suspend fun delFromLib(mediaId: Int): DeleteFromLibResponse {
        val response = api.removeFromLib(mediaId)
        return when (response.code()) {
            204 -> DeleteFromLibResponse.Success
            404 -> DeleteFromLibResponse.NotFound(response.body()!!)
            else -> DeleteFromLibResponse.Error(response.code(), response.body()!!)
        }
    }

    suspend fun save(mediaId: Int): FavResponse {
        val response = api.save(mediaId)
        return when (response.code()) {
            201     -> FavResponse.Success(response.body()!!)
            else    -> FavResponse.Error(
                response.code(),
                response.body()?.code,
                response.body()?.message
            )
        }
    }
}

sealed class LibraryResponse {
    data class Success(val libItem: LibraryItem): LibraryResponse()
    data class Error(val errorCode: Int, val code: String?, val message: String?) : LibraryResponse()
}

sealed class FavResponse {
    data class Success(val favorite: Favorite): FavResponse()
    data class Error(val errorCode: Int, val code: String?, val message: String?) : FavResponse()
}

sealed class DeleteFromLibResponse {
    data object Success: DeleteFromLibResponse()
    data class NotFound(val error: HttpErrorCodeMessage): DeleteFromLibResponse()
    data class Error(val errorCode: Int, val error: HttpErrorCodeMessage): DeleteFromLibResponse()
}