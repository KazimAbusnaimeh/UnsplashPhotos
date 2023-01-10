package com.mycompany.data.di

import com.mycompany.data.BuildConfig.BASE_URL
import com.mycompany.data.datasource.PhotosDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object Modules {

    @Provides
    fun getApi(): PhotosDataSource {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PhotosDataSource::class.java)
    }
}