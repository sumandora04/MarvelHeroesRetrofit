package com.notepoint4ugmail.marvelheroesretrofit.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class HeroesData(
    val id:Int,
    @Json(name = "image") val imageUrl:String,
    val rating:String,
    @Json(name = "like_percent")val likePercent:Int,
    val title:String,
    val language:String

) : Parcelable