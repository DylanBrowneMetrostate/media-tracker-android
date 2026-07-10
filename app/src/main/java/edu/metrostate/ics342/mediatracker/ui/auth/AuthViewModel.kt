package edu.metrostate.ics342.mediatracker.ui.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.metrostate.ics342.mediatracker.data.LoginResult
import edu.metrostate.ics342.mediatracker.data.UserRepository
import edu.metrostate.ics342.mediatracker.data.network.DefaultUserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import edu.metrostate.ics342.mediatracker.R
import edu.metrostate.ics342.mediatracker.data.SessionRepository
import edu.metrostate.ics342.mediatracker.data.datastore.DefaultSessionRepository

class AuthViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository = DefaultUserRepository()
    private val sessionRepository: SessionRepository = DefaultSessionRepository(application)

    sealed class AuthUiState {
        data object Idle    : AuthUiState()
        data object Loading : AuthUiState()
        data object Success : AuthUiState()
        data class Error(val msgResId: Int) : AuthUiState()
    }

    // ── Login ─────────────────────────────────────────────────────────────

    private val _email    = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _loginState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val loginState: StateFlow<AuthUiState> = _loginState.asStateFlow()

    fun onEmailChange(value: String)    { _email.value    = value }
    fun onPasswordChange(value: String) { _password.value = value }

    fun onLoginClick() {
        viewModelScope.launch {
            _loginState.value = AuthUiState.Loading
            delay(800)
            
            if (_email.value.isBlank() || _password.value.isBlank()) {
                _loginState.value = AuthUiState.Error(R.string.error_empty_credentials)
            } else {
                val loginAttempt = userRepository.login(email = _email.value, password = _password.value)
                _loginState.value = when (loginAttempt) {
                    is LoginResult.Success -> {
                        sessionRepository.saveSession(
                            accessToken  = loginAttempt.accessToken,
                            refreshToken = loginAttempt.refreshToken,
                            user         = loginAttempt.user
                        )
                        AuthUiState.Success
                    }
                    LoginResult.Conflict -> AuthUiState.Error(R.string.error_bad_login_credentials)
                    else -> AuthUiState.Error(R.string.error_login_failed)
                }
            }
        }
    }

    fun resetLoginState() { _loginState.value = AuthUiState.Idle }

}
