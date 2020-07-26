package com.berkayak.myrecentphotos.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.berkayak.myrecentphotos.data.model.Photo
import com.berkayak.myrecentphotos.databinding.ItemPhotoBinding

class PhotoViewHolder(private val binding: ItemPhotoBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: Photo, adapterListener: PhotoAdapterListener?) {
        binding.bean = photo
        binding.clickListener = adapterListener
    }
}