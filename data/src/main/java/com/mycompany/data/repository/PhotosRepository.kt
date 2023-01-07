package com.mycompany.data.repository

import com.mycompany.data.datasource.PhotosApi
import com.mycompany.data.models.Photos
import javax.inject.Inject

class PhotosRepository @Inject constructor(private val api: PhotosApi) {
    suspend fun getPhotos(): Photos {
        return api.getPhotos()
    }
}