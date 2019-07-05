package com.notepoint4ugmail.marvelheroesretrofit.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide

import com.notepoint4ugmail.marvelheroesretrofit.R
import com.notepoint4ugmail.marvelheroesretrofit.databinding.FragmentMovieDetailBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class MovieDetailFragment : Fragment() {

    private lateinit var detailViewModel: MovieDetailViewModel
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_detail,container,false)
        binding = FragmentMovieDetailBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        val application = requireNotNull(activity).application
        val heroesData =MovieDetailFragmentArgs.fromBundle(arguments!!).selectedMovies

        val modelFactory =MovieDetailModelFactory(heroesData,application)
        val viewModel = ViewModelProviders.of(this,modelFactory).get(MovieDetailViewModel::class.java)

        binding.detailViewModel = viewModel

        viewModel.movieTitle.observe(this, Observer {
            binding.movieTitle.text = it
        })

        viewModel.movieLanguage.observe(this, Observer {
            binding.movieLanguage.text = it
        })

        viewModel.movieRating.observe(this, Observer {
            binding.movieRating.text = it
        })

        viewModel.movieLikes.observe(this, Observer {
            binding.movieLikePercent.text = it.toString()
        })

//        viewModel.movieImage.observe(this, Observer {
//            val imageUri = it.toUri().buildUpon().scheme("https").build()
//            Glide.with(binding.movieImage)
//                .load(imageUri)
//                .into(binding.movieImage)
//        })



        return binding.root
    }


}
