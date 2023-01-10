package com.mycompany.data.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_image")
    val profileImage: ProfileImage
)