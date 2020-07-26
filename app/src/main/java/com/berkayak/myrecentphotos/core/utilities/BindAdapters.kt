package com.berkayak.myrecentphotos.core.utilities

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.berkayak.myrecentphotos.R
import com.berkayak.myrecentphotos.data.model.Photo
import com.berkayak.myrecentphotos.ui.viewholder.PhotoClickListener
import com.squareup.picasso.Picasso

@BindingAdapter("bind:loadDynamicPhoto")
fun ImageView.loadDynamic(photo: Photo) {
    val url = "https://live.staticflickr.com/${photo.server}/${photo.id}${photo.secret}.jpg"

    Picasso
        .with(this.context)
        .load(url)
        .placeholder(R.drawable.sample)
        .error(R.drawable.sample)
        .fit()
        .centerCrop()
        .into(this)
}
