package com.neobis.testproject.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neobis.testproject.data.model.ProductItem
import com.neobis.testproject.databinding.ProductItemBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var list = listOf<ProductItem>()

    inner class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setProduct(item: ProductItem) {
            with(binding){
                productName.text = item.title ?: "N/A"
                productPrice.text = item.price.toString() ?: "N/A"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setProduct(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(list:List<ProductItem>){
        this.list = list
        notifyDataSetChanged()
    }


}