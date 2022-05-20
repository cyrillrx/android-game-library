package com.cyrillrx.library.ui.gamelist

import com.cyrillrx.library.model.Game

data class GameListScreenState(
    val games: List<Game>,
    val isLoading: Boolean,
)
