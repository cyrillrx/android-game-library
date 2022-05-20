package com.cyrillrx.library.ui.gamelist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import com.cyrillrx.library.data.LocalGameStore
import com.cyrillrx.library.model.Game
import com.cyrillrx.library.ui.common.EmptyState
import com.cyrillrx.library.ui.common.Loader
import com.cyrillrx.library.ui.theme.AppTheme

@ExperimentalCoilApi
@Composable
fun GameListScreen(
    viewModel: GameListViewModel,
    navigateToGame: (Game) -> Unit,
) {
    GameListScreen(viewModel.uiState, navigateToGame)
}

@ExperimentalCoilApi
@Composable
fun GameListScreen(
    uiState: GameListScreenState,
    navigateToGame: (Game) -> Unit,
) {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

            val games = uiState.games
            when {
                uiState.isLoading -> Loader()
                games.isEmpty() -> EmptyState("No Games")
                else -> GameList(games, navigateToGame)
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
private fun GameList(games: List<Game>, navigateToGame: (Game) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        items(games) { game ->
            val releaseYear = game.releasedAt.split("-").first()
            val title = "${game.name} ($releaseYear)"

            val duration = "${game.duration.inWholeMinutes} minutes"
            val age = "à partir de ${game.age} ans"
            val playerCount = with(game.playerCount) { "$min à $max joueurs" }
            val subtitle = "${duration}\n${age}\n${playerCount}"

            GameItem(
                title = title,
                subtitle = subtitle,
                imageUrl = game.imageUrls.firstOrNull(),
                onItemClicked = { navigateToGame(game) },
            )
        }
    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun MainScreenLoadingPreview() {
    GameListScreen(GameListScreenState(emptyList(), true)) {}
}

@ExperimentalCoilApi
@Preview
@Composable
fun MainScreenPreview() {
    val games = LocalGameStore().fetch()
    val uiState = GameListScreenState(games = games, isLoading = false)
    GameListScreen(uiState) {}
}
