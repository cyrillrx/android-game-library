package com.cyrillrx.services

import com.cyrillrx.data.Game
import com.cyrillrx.data.GameEntity
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate
import java.time.LocalDateTime

class GameService {

    fun getAllGames(): Iterable<Game> = transaction {
        GameEntity.all().map(GameEntity::toGame)
    }

    fun addGame(game: Game) = transaction {
        GameEntity.new {
            this.name = game.name
            this.description = game.description
            this.age = game.age
            this.durationInMinutes = game.duration
            this.minPlayer = game.playerCount.min
            this.maxPlayer = game.playerCount.max

            val releasedAtParts = game.releasedAt.split("-")
            val year = releasedAtParts[0].toInt()
            val month = releasedAtParts[1].toInt()
            val day = releasedAtParts[2].toInt()
            this.releasedAt = LocalDate.of(year, month, day)

            this.imageUrls = game.description

            val now = LocalDateTime.now()
            this.createdAt = now
            this.updatedAt = now
        }
    }

    fun deleteBook(gameId: Int) = transaction {
        GameEntity[gameId].delete()
    }
}