package com.cyrillrx.plugins

import com.cyrillrx.data.Games
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.initDB() {
    val appConfig = environment.config
    val url = appConfig.property("ktor.database.url").getString()
    val user = appConfig.property("ktor.database.user").getString()
    val password = appConfig.property("ktor.database.password").getString()

    Database.connect(
        url = url,
        driver = "com.mysql.cj.jdbc.Driver",
        user = user,
        password = password,
    )

    createTables()
}

private fun createTables() = transaction {
    SchemaUtils.create(Games)
}