package com.berkayak.myrecentphotos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.berkayak.myrecentphotos.R
import com.berkayak.myrecentphotos.data.model.Photo
import com.berkayak.myrecentphotos.databinding.FragmentPhotoDetailBinding

class PhotoDetailFragment : Fragment() {

    private lateinit var binding: FragmentPhotoDetailBinding
    private var photo: Photo? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_photo_detail,
            container,
            false
        )
        binding.photo = photo
        return binding.root
    }

    companion object {
        const val TAG = "PhotoDetailFragment"

        fun newInstance(photo: Photo) = PhotoDetailFragment().apply {
            this.photo = photo
        }
    }
}