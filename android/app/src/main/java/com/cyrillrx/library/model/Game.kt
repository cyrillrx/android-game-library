package com.cyrillrx.library.model

import kotlin.time.Duration

class Game(
    val name: String,
    val description: String,
    val age: Int,
    val playerCount: PlayerCount,
    val duration: Duration,
    val imageUrls: List<String>,
    val releasedAt: String,
    val acquiredAt: String,
) {
    class PlayerCount(
        val min: Int,
        val max: Int,
    )
}