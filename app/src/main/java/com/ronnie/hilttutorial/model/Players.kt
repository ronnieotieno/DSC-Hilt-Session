package com.ronnie.hilttutorial.model

import com.google.gson.annotations.SerializedName


data class Players(
    @SerializedName("data")
    val playersList: List<Player>,
    val meta: Meta
)