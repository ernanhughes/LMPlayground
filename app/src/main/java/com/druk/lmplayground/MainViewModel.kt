package com.druk.lmplayground

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.druk.llamacpp.LlamaCpp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Used to communicate between screens.
 */
class MainViewModel : ViewModel() {

    private val _drawerShouldBeOpened = MutableStateFlow(false)
    val drawerShouldBeOpened = _drawerShouldBeOpened.asStateFlow()

    val llamaCpp = LlamaCpp()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                llamaCpp.init()
            }
        }
    }

    fun openDrawer() {
        _drawerShouldBeOpened.value = true
    }

    fun resetOpenDrawerAction() {
        _drawerShouldBeOpened.value = false
    }
}
