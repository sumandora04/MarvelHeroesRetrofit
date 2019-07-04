package com.notepoint4ugmail.marvelheroesretrofit.network

import com.squareup.moshi.Json

data class HeroesData(
    val id:Int,
    @Json(name = "image") val imageUrl:String,
    val rating:String,
    @Json(name = "like_percent")val likePercent:Int,
    val title:String,
    val language:String

)
