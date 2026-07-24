package edu.metrostate.ics342.mediatracker.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.metrostate.ics342.mediatracker.data.UserRepository
import edu.metrostate.ics342.mediatracker.data.datastore.DefaultSessionRepository
import edu.metrostate.ics342.mediatracker.data.model.Favorite
import edu.metrostate.ics342.mediatracker.data.model.Media
import edu.metrostate.ics342.mediatracker.data.network.DefaultLibraryRepository
import edu.metrostate.ics342.mediatracker.data.network.DefaultMediaRepository
import edu.metrostate.ics342.mediatracker.data.network.DefaultUserRepository
import edu.metrostate.ics342.mediatracker.data.network.LibraryResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MediaDetailViewModel(application: Application) : AndroidViewModel(application)  {
    // TODO (Week 7): Accept mediaId, call GET /media/{id}, expose MediaDetail state.
    // Also call GET /library to load current status for this item.

    private val mediaRepository: DefaultMediaRepository = DefaultMediaRepository(
        DefaultSessionRepository(application)
    )

    private val libraryRepository: DefaultLibraryRepository = DefaultLibraryRepository(
        DefaultSessionRepository(application)
    )

    private val _mediaId = MutableStateFlow(-1)
    val mediaId: StateFlow<Int> = _mediaId.asStateFlow()

    private val _media: MutableStateFlow<Media?> = MutableStateFlow(null)
    val media: StateFlow<Media?> = _media.asStateFlow()

    //TODO: have button change if favoreted / in library
    private val _fav: MutableStateFlow<Favorite?> = MutableStateFlow(null)
    val fav: StateFlow<Favorite?> = _fav.asStateFlow()

    private val _isFav = MutableStateFlow(fav.value == null)
    val isFav: StateFlow<Boolean> = _isFav.asStateFlow()

    fun setMediaId(id: Int) { _mediaId.value = id; updateMediaDetail()}

    private fun updateMediaDetail() {
        viewModelScope.launch {
            _media.value = mediaRepository.mediaDetail(mediaId.value)
        }
    }

    fun toggleInLibrary(status: String) {
        //TODO Understanding was wrong
        // Should not toggle, needs to be fixed
        var inLibrary: Boolean = false
        viewModelScope.launch {
            inLibrary = libraryRepository.getFromLib(mediaId.value) is LibraryResponse.Success
        }
        if (inLibrary) {
            addTo(status)
        } else {
            deleteFrom()
        }
    }

    private fun addTo(status: String) {
        viewModelScope.launch {
            libraryRepository.addTo(_mediaId.value, status)
        }
    }

    private fun deleteFrom() {
        viewModelScope.launch {
            libraryRepository.delFromLib(_mediaId.value)
        }
    }

    fun save() {
        viewModelScope.launch {
            libraryRepository.save(_mediaId.value)
        }
    }
}
