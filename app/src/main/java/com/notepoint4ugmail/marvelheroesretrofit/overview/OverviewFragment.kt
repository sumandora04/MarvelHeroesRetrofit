package com.notepoint4ugmail.marvelheroesretrofit.overview

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.notepoint4ugmail.marvelheroesretrofit.R
import com.notepoint4ugmail.marvelheroesretrofit.databinding.OverviewFragmentBinding

class OverviewFragment : Fragment() {
    private lateinit var overviewViewModel: OverviewViewModel
    private lateinit var binding: OverviewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.overview_fragment,
            container,
            false
        )

        overviewViewModel = ViewModelProviders.of(this).get(OverviewViewModel::class.java)

        binding.viewModel = overviewViewModel

        binding.lifecycleOwner = this

        val adapter = OverviewAdapter()
        binding.heroesRecycler.adapter = adapter

        overviewViewModel.movies.observe(this, Observer {

            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }


}
