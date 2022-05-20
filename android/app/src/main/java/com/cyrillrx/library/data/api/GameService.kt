package com.cyrillrx.library.data.api

import com.cyrillrx.library.model.Game
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface GameService {

    @GET("games")
    suspend fun getGames() : List<Game>?

    @GET("game/{id}")
    suspend fun getGame(@Path("id") id: String) : Game?

    @POST("game")
    suspend fun addGame(@Body game: Game) : Any?

    @DELETE("game/{id}")
    suspend fun deleteGame() : Any?
}

