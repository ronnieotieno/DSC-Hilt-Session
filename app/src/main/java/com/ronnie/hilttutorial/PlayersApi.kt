package com.ronnie.hilttutorial

import com.ronnie.hilttutorial.model.Players
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayersApi {
    @GET("players")
    suspend fun getPlayers(
        @Query("per_page") per_page: Int?,
        @Query("page") page: Int?,
    ): Players
}