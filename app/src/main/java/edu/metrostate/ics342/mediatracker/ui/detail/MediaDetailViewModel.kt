package edu.metrostate.ics342.mediatracker.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.metrostate.ics342.mediatracker.data.UserRepository
import edu.metrostate.ics342.mediatracker.data.datastore.DefaultSessionRepository
import edu.metrostate.ics342.mediatracker.data.model.Media
import edu.metrostate.ics342.mediatracker.data.network.DefaultMediaRepository
import edu.metrostate.ics342.mediatracker.data.network.DefaultUserRepository
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

    private val _mediaId = MutableStateFlow(-1)
    val mediaId: StateFlow<Int> = _mediaId.asStateFlow()

    private val _media: MutableStateFlow<Media?> = MutableStateFlow(null)
    val media: StateFlow<Media?> = _media.asStateFlow()

    fun setMediaId(id: Int) { _mediaId.value = id }

    fun updateMediaDetail() {
        viewModelScope.launch {
            _media.value = mediaRepository.mediaDetail(mediaId.value)
        }
    }
}
