package com.notepoint4ugmail.marvelheroesretrofit.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.notepoint4ugmail.marvelheroesretrofit.databinding.ImageGridBinding
import com.notepoint4ugmail.marvelheroesretrofit.network.HeroesData

class OverviewAdapter(private val onClickListener: OnClickListener): ListAdapter<HeroesData,OverviewAdapter.MoviesHolder>(HeroesDiffCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        return MoviesHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        val movieItem = getItem(position)
        //Set the onclick listener:
        holder.itemView.setOnClickListener {
            onClickListener.onClick(movieItem)
        }

        holder.bind(movieItem)

    }

    class MoviesHolder(private var binding: ImageGridBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie:HeroesData){
            binding.heroesMovie = movie
            binding.executePendingBindings()

//            val imgUri = movie.imageUrl.toUri().buildUpon().scheme("https").build()
//            Glide.with(binding.gridImageCell)
//                .load(imgUri)
//                .into(binding.gridImageCell)

        }

        companion object {
            fun from(parent: ViewGroup): MoviesHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ImageGridBinding.inflate(layoutInflater, parent, false)
                return MoviesHolder(binding)
            }
        }
    }


    class HeroesDiffCallBack : DiffUtil.ItemCallback<HeroesData>(){
        override fun areItemsTheSame(oldItem: HeroesData, newItem: HeroesData): Boolean {
            return oldItem.id== newItem.id
        }
        override fun areContentsTheSame(oldItem: HeroesData, newItem: HeroesData): Boolean {
            return oldItem==newItem
        }
    }


    class OnClickListener(private val clickListener:(HeroesData)->Unit){
        fun onClick(heroes:HeroesData): Unit = clickListener(heroes)
    }


}