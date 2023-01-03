package com.mycompany.unsplashphoto.datasource

import com.mycompany.unsplashphoto.models.Photos
import com.mycompany.unsplashphoto.utils.Constants.ACCESS_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {

    @Headers("Accept-Version: v1", "Authorization: Client-ID $ACCESS_KEY")
    @GET("photos")
    fun getPhotos(): Call<Photos>
}