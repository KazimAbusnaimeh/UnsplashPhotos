package com.mycompany.data.repository

import com.mycompany.data.datasource.Api
import com.mycompany.data.models.Photos
import javax.inject.Inject

class Repository @Inject constructor(private val api: Api) {
    suspend fun getPhotos(): Photos {
        return api.getPhotos()
    }
}