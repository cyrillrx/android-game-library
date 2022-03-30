package com.cyrillrx.library.ui.gamelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
class GameListActivity : ComponentActivity() {

    private val viewModel by viewModels<GameListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GameListScreen(viewModel)
        }
    }
}
