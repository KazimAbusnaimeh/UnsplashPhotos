package com.mycompany.unsplashphoto.models

data class CurrentUserCollection(
    val cover_photo: Any,
    val id: Int,
    val last_collected_at: String,
    val published_at: String,
    val title: String,
    val updated_at: String,
    val user: Any
)