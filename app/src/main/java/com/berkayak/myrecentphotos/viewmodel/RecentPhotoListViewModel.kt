package com.berkayak.myrecentphotos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkayak.myrecentphotos.core.utilities.Const
import com.berkayak.myrecentphotos.data.model.GenericResponse
import com.berkayak.myrecentphotos.data.model.RecentPhotosResponse
import com.berkayak.myrecentphotos.data.repository.RecentPhotosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RecentPhotoListViewModel(private val repository: RecentPhotosRepository) : ViewModel() {

    private val photosLiveData = MutableLiveData<GenericResponse<RecentPhotosResponse>>()

    fun observeRecentPhotos(): LiveData<GenericResponse<RecentPhotosResponse>> = photosLiveData

    fun getRecentPhotos(perPage: Int = Const.DEFAULT_PAGE_SIZE, page: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            photosLiveData.postValue(
                repository.getRecentPhotos(
                    perPage.toString(),
                    page.toString()
                )
            )
        }
    }
}