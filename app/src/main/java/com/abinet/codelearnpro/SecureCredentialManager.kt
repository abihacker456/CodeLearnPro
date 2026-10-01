package com.abinet.codelearnpro

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "api_credentials")

object SecureCredentialManager {
    private val CLIENT_ID_KEY = stringPreferencesKey("jdoodle_client_id")
    private val CLIENT_SECRET_KEY = stringPreferencesKey("jdoodle_client_secret")

    private var _clientId: String? = null
    private var _clientSecret: String? = null

    fun initialize(context: Context) {
        // Load credentials on app start
        // Note: In production, use EncryptedSharedPreferences instead
    }

    suspend fun saveCredentials(context: Context, clientId: String, clientSecret: String) {
        context.dataStore.edit { preferences ->
            preferences[CLIENT_ID_KEY] = clientId
            preferences[CLIENT_SECRET_KEY] = clientSecret
        }
        _clientId = clientId
        _clientSecret = clientSecret
    }

    fun getClientId(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[CLIENT_ID_KEY]
        }
    }

    fun getClientSecret(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[CLIENT_SECRET_KEY]
        }
    }

    fun getClientIdSync(): String? = _clientId
    fun getClientSecretSync(): String? = _clientSecret

    fun isConfigured(): Boolean {
        return !_clientId.isNullOrEmpty() &&
                !_clientSecret.isNullOrEmpty() &&
                _clientId != "YOUR_CLIENT_ID" &&
                _clientSecret != "YOUR_CLIENT_SECRET"
    }
}