package com.example.foodapp.core.app

import android.app.Application

class App:Application() {

    companion object{
        var context:App?=null
            private set

    }

    override fun onCreate() {
        super.onCreate()
        context =this
    }


}