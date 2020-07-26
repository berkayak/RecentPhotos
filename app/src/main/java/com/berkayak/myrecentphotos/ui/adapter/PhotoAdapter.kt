package com.berkayak.myrecentphotos.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berkayak.myrecentphotos.data.model.Photo
import com.berkayak.myrecentphotos.databinding.ItemPhotoBinding
import com.berkayak.myrecentphotos.ui.viewholder.PhotoClickListener
import com.berkayak.myrecentphotos.ui.viewholder.PhotoViewHolder

class PhotoAdapter(
    photos: List<Photo>,
    private val onPhotoItemClick: PhotoClickListener?
) : RecyclerView.Adapter<PhotoViewHolder>() {

    private val photos = photos as MutableList<Photo>

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
        holder.bind(photos[position], onPhotoItemClick)
    }

    fun addPhotoList(photos: List<Photo>) {
        this.photos.addAll(photos)
        notifyDataSetChanged()
    }
}