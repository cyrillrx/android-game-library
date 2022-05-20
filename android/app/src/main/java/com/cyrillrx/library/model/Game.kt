package com.cyrillrx.library.model

import kotlin.time.Duration

class Game(
    val id: String,
    val name: String,
    val description: String,
    val age: Int,
    val duration: Duration,
    val playerCount: PlayerCount,
    val imageUrls: List<String>,
    val releasedAt: String,
    val acquiredAt: String,
) {
    class PlayerCount(
        val min: Int,
        val max: Int,
    )
}
