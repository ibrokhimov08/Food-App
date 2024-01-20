package com.example.foodapp.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foodapp.core.adapter.util.getPositionForAdapter
import com.example.foodapp.core.model.home.HomeResponse
import com.example.foodapp.databinding.ItemFoodsBinding

class FoodAdapter : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    private val data = ArrayList<HomeResponse>()
    private var position = getPositionForAdapter()


    fun setData(data: HomeResponse){
        this.data.clear()
        this.data.add(data)
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(private val binding: ItemFoodsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: HomeResponse) {
            binding.foodImage.load(data.homeResults!![getPositionForAdapter()].image)
            binding.about.text = data.homeResults[adapterPosition].title
            binding.foodName.text = data.homeResults[getPositionForAdapter()].imageType
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            ItemFoodsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bindData(data[position])
        this.position++
    }
}