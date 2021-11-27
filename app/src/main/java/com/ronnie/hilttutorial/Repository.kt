package com.ronnie.hilttutorial

object Repository {
    private val api: PlayersApi = RetrofitClientProvider.retrofit.create(PlayersApi::class.java)

    suspend fun getPlayers() = api.getPlayers(60, 1)
}