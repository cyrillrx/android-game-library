package com.cyrillrx.library.ui.gamedetail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
class GameDetailActivity : ComponentActivity() {

    private val viewModel by viewModels<GameDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GameDetailScreen(viewModel)
        }

        val gameId = intent.getStringExtra(ARG_GAME_ID)!!
        viewModel.refresh(gameId)
    }

    companion object {
        const val ARG_GAME_ID = "game_id"
    }
}
