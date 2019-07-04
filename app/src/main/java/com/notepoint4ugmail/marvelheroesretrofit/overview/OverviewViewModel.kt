package com.notepoint4ugmail.marvelheroesretrofit.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.notepoint4ugmail.marvelheroesretrofit.network.HeroesApi
import com.notepoint4ugmail.marvelheroesretrofit.network.HeroesData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


enum class HeroesApiStatus{
    LOADING,
    ERROR,
    DONE
}

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<HeroesApiStatus>()
    val status:LiveData<HeroesApiStatus>
    get() = _status

    private val _movies = MutableLiveData<List<HeroesData>>()
    val movies:LiveData<List<HeroesData>>
    get() = _movies

    private val viewModelJob = Job()
    private val scope = CoroutineScope(viewModelJob+Dispatchers.Main)

    init {
        getMoviesList()
    }

    private fun getMoviesList() {

        scope.launch {

            var getDeferredMoveis =HeroesApi.retrofitService.getAllHeroes()

            try {
                _status.value = HeroesApiStatus.LOADING
                val listResult = getDeferredMoveis.await()
                if (!listResult.isEmpty()){
                    _movies.value = listResult
                }
                _status.value = HeroesApiStatus.DONE
            } catch (e: Exception) {
                _status.value = HeroesApiStatus.ERROR
                _movies.value = ArrayList()
            }

        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
