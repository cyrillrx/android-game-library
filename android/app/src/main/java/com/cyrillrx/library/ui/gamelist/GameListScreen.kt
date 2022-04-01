package com.cyrillrx.library.ui.gamelist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import com.cyrillrx.library.data.GameStore
import com.cyrillrx.library.model.Game
import com.cyrillrx.library.ui.theme.AppTheme
import com.cyrillrx.library.ui.widget.GameItem

@ExperimentalCoilApi
@Composable
fun GameListScreen(viewModel: GameListViewModel) {
    GameListScreen(viewModel.uiState)
}

@ExperimentalCoilApi
@Composable
fun GameListScreen(uiState: GameListScreenState) {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

            val games = uiState.games
            when {
                uiState.isLoading -> Loader()
                games.isEmpty() -> EmptyState()
                else -> GameList(games)
            }
        }
    }
}

@Composable
private fun Loader() {
    CircularProgressIndicator(
        Modifier.wrapContentSize(Alignment.Center)
    )
}

@Composable
private fun EmptyState() {
    Text(text = "No Games", modifier = Modifier.wrapContentSize(Alignment.Center))
}

@ExperimentalCoilApi
@Composable
private fun GameList(games: List<Game>, modifier: Modifier = Modifier) {
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
                onItemClicked = { /* TODO */ },
            )
        }
    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun MainScreenLoadingPreview() {
    GameListScreen(GameListScreenState(emptyList(), true))
}

@ExperimentalCoilApi
@Preview
@Composable
fun MainScreenPreview() {
    val games = GameStore().get()
    val uiState = GameListScreenState(games = games, isLoading = false)
    GameListScreen(uiState)
}
