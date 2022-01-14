package com.neobis.testproject.data.retrofit

import com.neobis.testproject.data.model.Product
import com.neobis.testproject.data.model.ProductItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {

    @GET("ncafe/products/county/")
    suspend fun getAllProduct(): Response<ArrayList<ProductItem>>

}