package com.abinet.codelearnpro

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
    private val _isDarkTheme = mutableStateOf(false)
    val isDarkTheme: State<Boolean> = _isDarkTheme

    fun toggleTheme() {
        println("🔄 THEME DEBUG: Toggling theme from ${_isDarkTheme.value} to ${!_isDarkTheme.value}")
        _isDarkTheme.value = !_isDarkTheme.value
    }
}