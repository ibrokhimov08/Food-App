package com.example.foodapp.core.network.service

import com.example.foodapp.core.model.home.HomeResponse
import com.example.foodapp.core.model.home.HomeResult
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {

    @GET("/recipes/complexSearch")
    fun getFoodsWithPage(
        @Query("number")
        size: Int = 20,
        @Query("offset") page: Int = 0,
        @Query("apiKey") apiKey: String
    ): Single<Response<HomeResponse>>


}