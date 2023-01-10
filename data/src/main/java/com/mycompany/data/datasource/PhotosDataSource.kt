package com.mycompany.data.datasource

import com.mycompany.data.BuildConfig.ACCESS_KEY
import com.mycompany.data.models.Photos
import retrofit2.http.GET
import retrofit2.http.Headers

interface PhotosDataSource {

    @Headers("Accept-Version: v1", "Authorization: Client-ID $ACCESS_KEY")
    @GET("photos")
    suspend fun getPhotos(): Photos
}