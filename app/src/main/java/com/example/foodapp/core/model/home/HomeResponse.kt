package com.example.foodapp.core.model.home


import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("number")
    val number: Int?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("results")
    val homeResults: List<HomeResult>?,
    @SerializedName("totalResults")
    val totalResults: Int?
)