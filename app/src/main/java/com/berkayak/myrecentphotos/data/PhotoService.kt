package com.berkayak.myrecentphotos.data

import com.berkayak.myrecentphotos.core.utilities.Const
import com.berkayak.myrecentphotos.data.model.RecentPhotosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {

    @GET("services/rest")
    fun getRecentPhotos(@Query("per_page")perPage: String,
                        @Query("page")page: String,
                        @Query("api_key")api: String = Const.API_KEY,
                        @Query("method") method: String = "flickr.photos.getRecent",
                        @Query("format")format: String = Const.FORMAT_JSON,
                        @Query("nojsoncallback")nojsoncallback: Int = 1): Response<RecentPhotosResponse>

}