package com.notepoint4ugmail.marvelheroesretrofit

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.notepoint4ugmail.marvelheroesretrofit.network.HeroesData
import com.notepoint4ugmail.marvelheroesretrofit.overview.OverviewAdapter


@BindingAdapter("imageBinder")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()

        Glide.with(imageView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_foreground))
            .into(imageView)
    }
}

@BindingAdapter("listRecyclerBind")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<HeroesData>?) {
    val adapter = recyclerView.adapter as OverviewAdapter
    adapter.submitList(data)
}
