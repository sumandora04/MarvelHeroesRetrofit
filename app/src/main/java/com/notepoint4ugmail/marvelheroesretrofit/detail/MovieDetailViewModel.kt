package com.notepoint4ugmail.marvelheroesretrofit.detail

import android.app.Application
import androidx.lifecycle.*
import com.bumptech.glide.Glide
import com.notepoint4ugmail.marvelheroesretrofit.network.HeroesData

class MovieDetailViewModel(heroesData: HeroesData, application: Application) : AndroidViewModel(application) {

    private val _selectedMovie = MutableLiveData<HeroesData>()
    val selectedMovie: LiveData<HeroesData>
        get() = _selectedMovie

    private val _movieTitle = MutableLiveData<String>()
    val movieTitle: LiveData<String>
        get() = _movieTitle

    init {
        _selectedMovie.value = heroesData
        _movieTitle.value = heroesData.title
    }



    val movieRating =  Transformations.map(selectedMovie) {
        it.rating
    }

    val movieLikes = Transformations.map(selectedMovie) {
        it.likePercent
    }

    val movieLanguage = Transformations.map(selectedMovie) {
        it.language
    }

    val movieImage = Transformations.map(selectedMovie) {
        it.imageUrl
    }
}