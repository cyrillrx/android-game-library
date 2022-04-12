package com.cyrillrx.data

import com.google.gson.Gson
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date
import org.jetbrains.exposed.sql.javatime.datetime

object Games : IntIdTable(name = "games") {
    val name = varchar("name", 255)
    val description = text("description")
    val age = integer("age")
    val duration_in_minutes = integer("duration_in_minutes")
    val min_player = integer("min_player")
    val max_player = integer("max_player")
    val released_at = date("released_at")
    val image_urls = text("image_urls")
    val created_at = datetime("created_at")
    val updated_at = datetime("updated_at")
}

class GameEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<GameEntity>(Games)

    var name by Games.name
    var description by Games.description
    var age by Games.age
    var durationInMinutes by Games.duration_in_minutes
    var minPlayer by Games.min_player
    var maxPlayer by Games.max_player
    var releasedAt by Games.released_at
    var imageUrls by Games.image_urls
    var createdAt by Games.created_at
    var updatedAt by Games.updated_at

    override fun toString(): String = "BoardGame($name, ${releasedAt.year})"

    fun toGame() = Game(
        id.value,
        name,
        description,
        age,
        durationInMinutes,
        Game.PlayerCount(minPlayer, maxPlayer),
        Gson().fromJson(imageUrls, Game.Images::class.java),
        releasedAt.toString(),
    )
}

class Game(
    val id: Int,
    val name: String,
    val description: String,
    val age: Int,
    val duration: Int,
    val playerCount: PlayerCount,
    val imageUrls: Images,
    val releasedAt: String,
) {
    class PlayerCount(
        val min: Int,
        val max: Int,
    )

    class Images : ArrayList<String>()
}