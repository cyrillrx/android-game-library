package com.cyrillrx.library.ui.gamelist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.cyrillrx.library.data.GameStore
import com.cyrillrx.library.model.Game

class GameListViewModel : ViewModel() {

    private val games: MutableList<Game> = ArrayList(GameStore().get())

    var uiState by mutableStateOf(GameListScreenState(games = games, isLoading = false))
}
