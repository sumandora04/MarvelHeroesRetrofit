package com.notepoint4ugmail.marvelheroesretrofit.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.notepoint4ugmail.marvelheroesretrofit.network.HeroesData
import java.lang.IllegalArgumentException

class MovieDetailModelFactory(private val heroesData: HeroesData, private val application: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)){
            return MovieDetailViewModel(heroesData,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}