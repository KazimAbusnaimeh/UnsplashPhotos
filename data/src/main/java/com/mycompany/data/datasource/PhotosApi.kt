package com.mycompany.data.datasource

import com.mycompany.data.models.Photos
import com.mycompany.data.utils.Constants.ACCESS_KEY
import retrofit2.http.GET
import retrofit2.http.Headers

interface PhotosApi {

    @Headers("Accept-Version: v1", "Authorization: Client-ID $ACCESS_KEY")
    @GET("photos")
    suspend fun getPhotos(): Photos
}