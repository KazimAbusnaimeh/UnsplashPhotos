package com.mycompany.unsplashphoto.di

import com.mycompany.unsplashphoto.datasource.Api
import com.mycompany.unsplashphoto.utils.Constants
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
    fun getApi(): Api {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)
    }
}