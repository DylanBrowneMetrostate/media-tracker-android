/*package edu.metrostate.ics342.mediatracker.data

interface UserRepository {
    suspend fun register(
        email: String,
        password: String,
        username: String,
        displayName: String
    ): RegisterResult
}

sealed interface RegisterResult {
    data object Success : RegisterResult
    data object Conflict : RegisterResult
    data object NetworkError : RegisterResult
    data object UnknownError : RegisterResult
}
*/
package edu.metrostate.ics342.mediatracker.data

import edu.metrostate.ics342.mediatracker.data.model.CreateUserRequest
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

const val baseURL = "https://wjtzkgpxmxtzcczzbvrz.supabase.co/functions/v1/"


class UserRepository {
    private val clientId = "ics342-dylan-browne"
    private val clientSecret = "mt-NVXu6jTerPy8bhHjaZ"

    private val json = Json {ignoreUnknownKeys = true}

    private val api: ApiService = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(
            json.asConverterFactory(
                "application/json".toMediaType()))
        .build()
        .create(ApiService::class.java)

    suspend fun createAccount(
        displayName: String,
        username: String,
        email: String,
        password: String
    ) {
        val createUserRequest = CreateUserRequest(
            email = email,
            password = password,
            username = username,
            displayName = displayName,
            clientId = clientId,
            clientSecret = clientSecret
        )
        api.createUser(createUserRequest)
    }
}