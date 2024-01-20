package com.example.foodapp.core.model.home


import com.google.gson.annotations.SerializedName

data class HomeResult(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("imageType")
    val imageType: String?,
    @SerializedName("title")
    val title: String?
)