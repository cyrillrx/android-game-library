package com.cyrillrx.plugins

import com.cyrillrx.routes.apiRoute
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Application.configureRouting() {

    routing {
        get("/") {
            val name = "Welcome to Game Library API!"
            call.respondHtml(HttpStatusCode.OK) {
                head {
                    title {
                        +name
                    }
                }
                body {
                    h1 { +name }
                    h2 { +"Here are some available endpoints" }
                    ul {
                        li {
                            a {
                                href = "http://localhost:3000/api/v1/games"
                                +"GET http://localhost:3000/api/v1/games"
                            }
                        }
                        li {
                            a {
                                href = "http://localhost:3000/api/v1/game/1"
                                +"GET http://localhost:3000/api/v1/game/{id}"
                            }
                        }
                        li { +"POST http://localhost:3000/api/v1/game" }
                        li { +"DELETE http://localhost:3000/api/v1/game/{id}" }
                    }
                }
            }
        }

        apiRoute()
    }
}
