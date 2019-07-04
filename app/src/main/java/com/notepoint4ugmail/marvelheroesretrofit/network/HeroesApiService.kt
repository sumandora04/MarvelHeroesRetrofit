package com.notepoint4ugmail.marvelheroesretrofit.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.simplifiedcoding.in/course-apis/recyclerview/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface HeroesApiService {

    @GET("movies")
    fun getAllHeroes(): Deferred<List<HeroesData>>

}

object HeroesApi {
    val retrofitService: HeroesApiService by lazy {
        retrofit.create(HeroesApiService::class.java)
    }

}