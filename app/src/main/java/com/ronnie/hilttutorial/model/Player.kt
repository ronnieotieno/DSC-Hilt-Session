package com.ronnie.hilttutorial.model

data class Player(
    val first_name: String,
    val id: Int,
    val last_name: String,
    val position: String,
    val team: Team,
)