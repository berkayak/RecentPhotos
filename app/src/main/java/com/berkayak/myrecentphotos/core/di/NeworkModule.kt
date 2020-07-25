package com.berkayak.myrecentphotos.core.di

import com.berkayak.myrecentphotos.core.utilities.Const
import com.berkayak.myrecentphotos.data.PhotoService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        )
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Const.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideApi(retrofit: Retrofit): PhotoService {
    return retrofit.create(PhotoService::class.java)
}
