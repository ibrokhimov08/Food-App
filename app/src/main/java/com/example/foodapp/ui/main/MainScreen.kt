package com.example.foodapp.ui.main

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.foodapp.R
import com.example.foodapp.core.adapter.MainAdapter
import com.example.foodapp.core.base.BaseFragment
import com.example.foodapp.databinding.ScreenMainBinding

class MainScreen:BaseFragment(R.layout.screen_main){
    private val binding by viewBinding(ScreenMainBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

        val adapter =MainAdapter(childFragmentManager,lifecycle)
        binding.viewpager.adapter=adapter
        binding.viewpager.isUserInputEnabled =false
        binding.bottomnavigationview.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeMenu->binding.viewpager.setCurrentItem(0,false)
                R.id.saveMenu->binding.viewpager.setCurrentItem(1,false)
                R.id.settingMenu->binding.viewpager.setCurrentItem(2,false)
            }



            true
        }



    }

}