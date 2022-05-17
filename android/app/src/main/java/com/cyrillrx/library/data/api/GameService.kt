package com.cyrillrx.library.data.api

import com.cyrillrx.library.model.Game
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface GameService {

    @GET("games")
    suspend fun getGames() : List<Game>?

    @POST("game")
    suspend fun addGame(@Body game: Game) : Any?

    @DELETE("game/{id}")
    suspend fun deleteGame() : Any?
}

