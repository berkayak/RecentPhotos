package com.berkayak.myrecentphotos.data.model


import com.google.gson.annotations.SerializedName

data class Photos(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: String,
    val photo: List<Photo>
)