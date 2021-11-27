package com.ronnie.hilttutorial

import javax.inject.Inject

class Repository @Inject constructor(private val api: PlayersApi) {
    suspend fun getPlayers() = api.getPlayers(60, 1)
}