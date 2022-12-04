package com.example.droi_mvvm.model

import java.io.Serializable

class DC_yo {
    data class Res(
        var total_count : Int = 0,
        var incomplete_results : Boolean = false,
        var items: ArrayList<Items> = ArrayList(),
    ) : Serializable
    data class Items(
        var login: String = "",
        var id: Int = 0,
        var avatar_url: String = "",
        var html_url: String = "",
        var like: Boolean = false,
    ) : Serializable
}


