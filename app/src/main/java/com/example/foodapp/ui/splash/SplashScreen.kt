package com.example.foodapp.ui.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.foodapp.R
import com.example.foodapp.core.base.BaseFragment
import com.example.foodapp.databinding.ScreenSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : BaseFragment(R.layout.screen_splash) {


    override fun onCreate(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            delay(1000)
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToMainScreen())
        }

    }

}