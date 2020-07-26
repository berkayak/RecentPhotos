package com.berkayak.myrecentphotos.core.utilities

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.berkayak.myrecentphotos.R
import com.berkayak.myrecentphotos.data.model.Photo
import com.berkayak.myrecentphotos.ui.adapter.BindableAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("bind:loadDynamicPhoto")
fun ImageView.loadDynamic(photo: Photo) {
    val url = "https://live.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_c.jpg"

    Picasso
        .with(this.context)
        .load(url)
        .placeholder(R.drawable.sample)
        .error(R.drawable.sample)
        .fit()
        .centerCrop()
        .into(this)
}

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, items: List<Any>) {
    (recyclerView.adapter as? BindableAdapter<Any, RecyclerView.ViewHolder>)?.let { safeAdapter ->
        safeAdapter.bindData(items)
    }
}
