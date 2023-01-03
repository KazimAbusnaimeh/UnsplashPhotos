package com.mycompany.unsplashphoto.repository

import com.mycompany.unsplashphoto.datasource.Api
import com.mycompany.unsplashphoto.models.PhotosItem
import retrofit2.Call
import javax.inject.Inject

class Repository @Inject constructor(private val api: Api) {
    suspend fun getPhotos(): Call<ArrayList<PhotosItem>> {
        return api.getPhotos()
    }
}