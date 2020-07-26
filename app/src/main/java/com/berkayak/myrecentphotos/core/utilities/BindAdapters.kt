package com.berkayak.myrecentphotos.core.utilities

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
        .placeholder(R.drawable.flicker)
        .error(R.drawable.flicker)
        .fit()
        .centerCrop()
        .into(this)
}

@BindingAdapter("data")
fun setRecyclerViewProperties(recyclerView: RecyclerView, items: List<Any>) {
    (recyclerView.adapter as? BindableAdapter<Any, RecyclerView.ViewHolder>)?.bindData(items)
}
