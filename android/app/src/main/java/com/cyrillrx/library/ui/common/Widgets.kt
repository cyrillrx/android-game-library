package com.cyrillrx.library.ui.common

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Loader() {
    CircularProgressIndicator(
        Modifier.wrapContentSize(Alignment.Center)
    )
}

@Composable
fun EmptyState(text: String) {
    Text(text = text, modifier = Modifier.wrapContentSize(Alignment.Center))
}
