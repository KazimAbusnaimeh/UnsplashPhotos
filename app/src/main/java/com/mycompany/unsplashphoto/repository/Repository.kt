package com.mycompany.unsplashphoto.repository

import com.mycompany.unsplashphoto.datasource.Api
import com.mycompany.unsplashphoto.models.Photos
import retrofit2.Call
import javax.inject.Inject

class Repository @Inject constructor(private val api: Api) {
    suspend fun getPhotos(): Call<Photos> {
        return api.getPhotos()
    }
}