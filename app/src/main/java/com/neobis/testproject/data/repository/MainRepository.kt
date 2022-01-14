package com.neobis.testproject.data.repository

import com.neobis.testproject.data.model.Product
import com.neobis.testproject.data.model.ProductItem
import com.neobis.testproject.data.retrofit.ProductAPI
import retrofit2.Call
import retrofit2.Response

class MainRepository(private val productAPI: ProductAPI) {

    suspend fun getAllProduct(): Response<ArrayList<ProductItem>> {
        return productAPI.getAllProduct()
    }

}