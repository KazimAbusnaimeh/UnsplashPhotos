package com.mycompany.data.models

import com.google.gson.annotations.SerializedName

data class ProfileImage(
    @SerializedName("large")
    val large: String
)