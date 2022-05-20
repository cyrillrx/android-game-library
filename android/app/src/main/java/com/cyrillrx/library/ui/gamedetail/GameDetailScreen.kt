package com.cyrillrx.library.ui.gamedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.cyrillrx.library.model.Game
import com.cyrillrx.library.ui.common.EmptyState
import com.cyrillrx.library.ui.common.Loader
import com.cyrillrx.library.ui.theme.AppTheme

@ExperimentalCoilApi
@Composable
fun GameDetailScreen(viewModel: GameDetailViewModel) {
    GameDetailScreen(viewModel.uiState)
}

@ExperimentalCoilApi
@Composable
fun GameDetailScreen(uiState: GameDetailScreenState) {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

            val game = uiState.game
            when {
                uiState.isLoading -> Loader()
                game == null -> EmptyState("Game not found")
                else -> GameDetail(modifier = Modifier, game)
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun GameDetail(
    modifier: Modifier = Modifier,
    game: Game,
) {
    val releaseYear = game.releasedAt.split("-").first()
    val title = "${game.name} ($releaseYear)"

    val duration = "${game.duration.inWholeMinutes} minutes"
    val age = "à partir de ${game.age} ans"
    val playerCount = with(game.playerCount) { "$min à $max joueurs" }
    val subtitle = "${duration}\n${age}\n${playerCount}"

    GameDetail(
        modifier = modifier,
        title = title,
        subtitle = subtitle,
        imageUrl = game.imageUrls.firstOrNull(),
    )
}

@ExperimentalCoilApi
@Composable
fun GameDetail(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageUrl: String?,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp),
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
            )
            Text(
                text = subtitle,
                color = Color.Gray,
                fontSize = 14.sp,
            )
        }
    }
}
