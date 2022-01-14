package com.neobis.testproject.data.model

data class ProductItem(
    val category_name: String,
    val county: Int,
    val description: String,
    val id: Int,
    val image: String,
    val isPopular: Boolean,
    val price: Int,
    val title: String
)