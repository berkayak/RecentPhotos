package com.berkayak.myrecentphotos.data.repository

import com.berkayak.myrecentphotos.core.utilities.Const
import com.berkayak.myrecentphotos.data.PhotoService
import com.berkayak.myrecentphotos.data.model.GenericResponse
import com.berkayak.myrecentphotos.data.model.RecentPhotosResponse

class RecentPhotosRepository(private val service: PhotoService) {

    suspend fun getRecentPhotos(
        perPage: String,
        page: String
    ): GenericResponse<RecentPhotosResponse> {
        return try {
            val response = service.getRecentPhotos(
                perPage = perPage,
                page = page
            )
            if (response.isSuccessful && response.body()?.stat == Const.RESPONSE_STATUS_OK) {
                GenericResponse.Success(response.body())
            } else {
                GenericResponse.Failure(response.body().toString())
            }
        } catch (e: Exception) {
            GenericResponse.Error(e)
        }
    }
}