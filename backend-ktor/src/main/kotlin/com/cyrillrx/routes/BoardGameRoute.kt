package com.cyrillrx.routes

import com.cyrillrx.data.Game
import com.cyrillrx.services.GameService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.boardGames() {

    val gameService = GameService()

    get("games") {
        val allGames = gameService.getAllGames()
        call.respond(allGames)
    }

    post("game") {
        val gameRequest = call.receive<Game>()
        gameService.addGame(gameRequest)
        call.respond(HttpStatusCode.Accepted)
    }

    delete("game/{id}") {
        val bookId = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
        gameService.deleteBook(bookId)
        call.respond(HttpStatusCode.OK)
    }
}