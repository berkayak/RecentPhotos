package com.berkayak.myrecentphotos.ui.viewholder

import com.berkayak.myrecentphotos.data.model.Photo

interface PhotoClickListener {
    fun clickListener(photo: Photo)
}