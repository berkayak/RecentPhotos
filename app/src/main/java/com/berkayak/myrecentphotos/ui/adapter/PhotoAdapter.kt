package com.berkayak.myrecentphotos.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.berkayak.myrecentphotos.core.utilities.Const
import com.berkayak.myrecentphotos.data.model.Photo
import com.berkayak.myrecentphotos.databinding.ItemPhotoBinding
import com.berkayak.myrecentphotos.ui.viewholder.PhotoAdapterListener
import com.berkayak.myrecentphotos.ui.viewholder.PhotoViewHolder

class PhotoAdapter(
    private val onPhotoListener: PhotoAdapterListener?
) : BindableAdapter<List<Photo>, PhotoViewHolder>() {

    private val photos = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position], onPhotoListener)
        if (position == photos.size - 1) {
            onPhotoListener?.onEndOfList()
        }
    }

    override fun bindData(data: List<Photo>) {
        photos.clear()
        photos.addAll(data)
        notifyDataSetChanged()
    }
}