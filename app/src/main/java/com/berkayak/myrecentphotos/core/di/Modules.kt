package com.berkayak.myrecentphotos.core.di

import com.berkayak.myrecentphotos.data.repository.RecentPhotosRepository
import com.berkayak.myrecentphotos.viewmodel.RecentPhotoListViewModel
import org.koin.dsl.module

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideApi(get()) }
    single { provideRetrofit(get()) }
}

val repositoryModule = module {
    factory { RecentPhotosRepository(get()) }
}

val viewModelModule = module {
    factory { RecentPhotoListViewModel(get()) }
}