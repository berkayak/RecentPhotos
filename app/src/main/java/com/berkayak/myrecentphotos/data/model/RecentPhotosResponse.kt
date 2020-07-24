package com.berkayak.myrecentphotos.data.model


import com.google.gson.annotations.SerializedName

data class RecentPhotosResponse(
    val photos: Photos,
    val stat: String
)