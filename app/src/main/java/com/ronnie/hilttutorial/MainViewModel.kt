package com.ronnie.hilttutorial

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    suspend fun getPlayers() = Repository.getPlayers()
}