package com.mycompany.data.models

import com.google.gson.annotations.SerializedName

data class PhotosItem(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("urls")
    val urls: Urls,
    @SerializedName("user")
    val user: User
)