package com.cyrillrx.library.ui.gamedetail

import com.cyrillrx.library.model.Game

data class GameDetailScreenState(
    val game: Game?,
    val isLoading: Boolean,
)
