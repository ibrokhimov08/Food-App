package com.example.foodapp.core.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodapp.ui.main.home.HomePage
import com.example.foodapp.ui.main.save.SavePage
import com.example.foodapp.ui.main.setting.SettingPage

class MainAdapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm, lc) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomePage()
            1 -> SavePage()
            else ->SettingPage()
        }
    }
}