package com.example.foodapp.ui.main.home

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.foodapp.R
import com.example.foodapp.core.adapter.FoodAdapter
import com.example.foodapp.core.base.BaseFragment
import com.example.foodapp.core.model.home.HomeResponse
import com.example.foodapp.databinding.PageHomeBinding
import com.example.foodapp.ui.main.home.presenter.HomeMVP
import com.example.foodapp.ui.main.home.presenter.HomePresenter

class HomePage : BaseFragment(R.layout.page_home), HomeMVP.View {
    private val binding by viewBinding(PageHomeBinding::bind)
    private val presenter = HomePresenter(this)
    private val adapter by lazy { FoodAdapter() }


    override fun onCreate(view: View, savedInstanceState: Bundle?) {

        loadAdapter()

    }

    private fun loadAdapter() {
        binding.rvList.adapter = adapter

    }

    override fun setData(data: HomeResponse) {

        data.let {
            adapter.setData(data = it)
        }

    }

    override fun setError(message: String) {

    }

}