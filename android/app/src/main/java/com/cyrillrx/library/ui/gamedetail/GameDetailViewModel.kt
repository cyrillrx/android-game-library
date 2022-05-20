package com.cyrillrx.library.ui.gamedetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyrillrx.library.data.api.GameApi
import kotlinx.coroutines.launch

class GameDetailViewModel : ViewModel() {

    var uiState by mutableStateOf(GameDetailScreenState(game = null, isLoading = false))

    fun refresh(gameId: String) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)

            val game = GameApi.apiV1.getGame(gameId)

            uiState = GameDetailScreenState(game = game, isLoading = false)
        }
    }
}
