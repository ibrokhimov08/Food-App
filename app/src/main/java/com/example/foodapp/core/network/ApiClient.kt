package com.example.foodapp.core.network

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.foodapp.BuildConfig
import com.example.foodapp.core.app.App
import com.example.foodapp.core.network.service.HomeService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object ApiClient {

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(provideOkHttp())
            .build()
    }

    private fun provideOkHttp():OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(1,TimeUnit.MINUTES)
            .writeTimeout(1,TimeUnit.MINUTES)
            .readTimeout(1,TimeUnit.MINUTES)
            .addInterceptor(checkerInterceptor())
            .addInterceptor(headerInterceptor())
            .build()

    }

    private fun checkerInterceptor():ChuckerInterceptor{
      return  ChuckerInterceptor.Builder(App.context!!)
            .collector(ChuckerCollector(App.context!!))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()

    }




    private fun headerInterceptor():Interceptor{
        return Interceptor{chain :  Interceptor.Chain->
            val request =chain.request()
            val builder:Request.Builder=request.newBuilder()
            builder.addHeader("Content-Type","application/json")
            val response =chain.proceed(builder.build())
            response
        }
    }


    fun createHomeService():HomeService= getRetrofit().create(HomeService::class.java)

}