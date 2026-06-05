package edu.metrostate.ics342.mediatracker.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.metrostate.ics342.mediatracker.data.UserRepository
import edu.metrostate.ics342.mediatracker.ui.auth.AuthViewModel.AuthUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel()  {
    private val userRepository = UserRepository()

    sealed class RegisterUiState {
        object Idle    : RegisterUiState()
        object Loading : RegisterUiState()
        object Success : RegisterUiState()
        data class Error(val msgResId: Int) : RegisterUiState()
    }

    private val _displayName = MutableStateFlow("")
    val displayName: StateFlow<String> = _displayName.asStateFlow()

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _email    = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword.asStateFlow()

    private val _registerState = MutableStateFlow<RegisterUiState>(RegisterUiState.Idle)
    val registerState: StateFlow<RegisterUiState> = _registerState.asStateFlow()


    fun onDisplayNameChange(value: String)    { _displayName.value    = value }
    fun onUsernameChange(value: String)    { _username.value    = value }
    fun onEmailChange(value: String)    { _email.value    = value }
    fun onPasswordChange(value: String) { _password.value = value }
    fun onConfirmPasswordChange(value: String)    { _confirmPassword.value    = value }

    fun onRegisterClick() {
        viewModelScope.launch {
            if (_displayName.value.isNotBlank() &&
                _username.value.isNotBlank() &&
                _email.value.isNotBlank() &&
                _password.value.isNotBlank() &&
                _confirmPassword.value.isNotBlank()
                ) {
                if (_password.value == _confirmPassword.value) {
                    if (_username.value.length >= 3 && _password.value.length >= 8) {
                        _registerState.value = RegisterUiState.Success
                        userRepository.createAccount(
                            displayName = _displayName.value,
                            username = _username.value,
                            email = _email.value,
                            password = _password.value
                        )
                    } else {
                        _registerState.value = RegisterUiState.Error(edu.metrostate.ics342.mediatracker.R.string.error_too_short_username_or_password)
                    }
                } else {
                    _registerState.value = RegisterUiState.Error(edu.metrostate.ics342.mediatracker.R.string.error_non_matching_password_and_confirm_password)
                }
            } else {
                _registerState.value = RegisterUiState.Error(edu.metrostate.ics342.mediatracker.R.string.error_empty_credentials_register)
            }
        }
    }

    fun resetRegisterState() { _registerState.value = RegisterUiState.Idle }

}