package com.berkayak.myrecentphotos.ui.bindable

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.berkayak.myrecentphotos.data.model.Photo

class PhotoListFragmentProps: BaseObservable() {

    @get:Bindable
    var photoList = listOf<Photo>()
    set(value) {
        field = value
        notifyPropertyChanged(BR.photoList)
    }

    @get:Bindable
    var pageInfo = "Recent Photos"
        set(value) {
            field = value
            notifyPropertyChanged(BR.pageInfo)
        }
}