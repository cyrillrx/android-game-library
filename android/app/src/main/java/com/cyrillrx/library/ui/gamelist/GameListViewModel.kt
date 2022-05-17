package com.cyrillrx.library.ui.gamelist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyrillrx.library.data.api.GameApi
import com.cyrillrx.library.model.Game
import kotlinx.coroutines.launch

class GameListViewModel : ViewModel() {

    private val games: MutableList<Game> = ArrayList()

    var uiState by mutableStateOf(GameListScreenState(games = games, isLoading = false))

    fun refresh() {
        viewModelScope.launch {
            uiState = GameListScreenState(games = games, isLoading = true)

            games.clear()
            val fetchedGames = GameApi.apiV1.getGames() ?: emptyList()
            games.addAll(fetchedGames)

            uiState = GameListScreenState(games = games, isLoading = false)
        }
    }
}
