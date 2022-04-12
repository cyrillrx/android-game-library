package com.cyrillrx

import com.cyrillrx.plugins.configureRouting
import com.cyrillrx.plugins.configureSerialization
import com.cyrillrx.plugins.initDB
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    initDB()
    configureRouting()
    configureSerialization()
}