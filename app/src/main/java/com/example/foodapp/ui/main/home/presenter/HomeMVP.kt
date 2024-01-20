package com.example.foodapp.ui.main.home.presenter

import android.view.textclassifier.ConversationActions.Message
import com.example.foodapp.core.model.home.HomeResponse

interface HomeMVP {
    interface View{
        fun setData(data:HomeResponse)
        fun setError(message: String)

    }
    interface Presenter{
        fun getFoods()
        fun cencelRequest()
    }
}