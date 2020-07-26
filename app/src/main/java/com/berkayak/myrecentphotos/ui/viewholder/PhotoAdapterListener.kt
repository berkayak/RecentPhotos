package com.berkayak.myrecentphotos.ui.viewholder

import com.berkayak.myrecentphotos.data.model.Photo

interface PhotoAdapterListener {
    fun clickListener(photo: Photo)
    fun onEndOfList()
}