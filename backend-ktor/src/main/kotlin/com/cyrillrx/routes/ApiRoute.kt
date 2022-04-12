package com.cyrillrx.routes

import io.ktor.server.routing.*

fun Routing.apiRoute() {
    route("/api/v1") {
        boardGames()
    }
}