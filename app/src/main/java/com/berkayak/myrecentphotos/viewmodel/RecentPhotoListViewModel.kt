package com.berkayak.myrecentphotos.viewmodel

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkayak.myrecentphotos.core.utilities.Const
import com.berkayak.myrecentphotos.core.utilities.startFragment
import com.berkayak.myrecentphotos.data.model.GenericResponse
import com.berkayak.myrecentphotos.data.model.Photo
import com.berkayak.myrecentphotos.data.model.RecentPhotosResponse
import com.berkayak.myrecentphotos.data.repository.RecentPhotosRepository
import com.berkayak.myrecentphotos.ui.adapter.PhotoAdapter
import com.berkayak.myrecentphotos.ui.fragment.PhotoDetailFragment
import com.berkayak.myrecentphotos.ui.viewholder.PhotoAdapterListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RecentPhotoListViewModel(
    private val repository: RecentPhotosRepository
) : ViewModel() {

    private val photosLiveData = MutableLiveData<GenericResponse<RecentPhotosResponse>>()
    var currentPage = 0

    fun observeRecentPhotos(): LiveData<GenericResponse<RecentPhotosResponse>> = photosLiveData

    fun getRecentPhotos(perPage: Int = Const.DEFAULT_PAGE_SIZE) {
        currentPage++
        GlobalScope.launch(Dispatchers.IO) {
            photosLiveData.postValue(
                repository.getRecentPhotos(
                    perPage.toString(),
                    currentPage.toString()
                )
            )
        }
    }

    fun createAdapter(activity: FragmentActivity?): PhotoAdapter =
        PhotoAdapter(object : PhotoAdapterListener {
            override fun clickListener(photo: Photo) {
                Log.d(Const.LOG_TAG, "photo item clicked")
                activity?.startFragment(
                    PhotoDetailFragment.newInstance(photo),
                    PhotoDetailFragment.TAG
                )
            }

            override fun onEndOfList() {
                Log.d(Const.LOG_TAG, "end of list")
                getRecentPhotos()
            }
        })
}
