package com.example.foodapp.ui.main.setting

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.foodapp.R
import com.example.foodapp.core.base.BaseFragment
import com.example.foodapp.databinding.PageSaveBinding

class SettingPage :BaseFragment(R.layout.page_setting){
    private val binding by viewBinding(PageSaveBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

    }

}