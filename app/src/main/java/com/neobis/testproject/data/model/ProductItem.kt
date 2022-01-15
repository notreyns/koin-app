package com.neobis.testproject.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProductName")
data class ProductItem(
    val category_name: String,
    val county: Int,
    val description: String,
    @PrimaryKey
    val id: Int = 0,
    val image: String,
    val isPopular: Boolean,
    val price: Int,
    val title: String
)
