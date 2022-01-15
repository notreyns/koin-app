package com.neobis.testproject.data.repository

import com.neobis.testproject.data.model.Product
import com.neobis.testproject.data.model.ProductItem
import com.neobis.testproject.data.retrofit.ProductAPI
import com.neobis.testproject.data.room.ProductDao
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

class MainRepository(private val productAPI: ProductAPI, private val productDao: ProductDao) {

    suspend fun getAllProduct(): Response<ArrayList<ProductItem>> {
        return productAPI.getAllProduct()
    }

    suspend fun insertData(model:ProductItem){
        return productDao.insertProduct(model)
    }

    suspend fun getAllProductFromRoom(): Flow<List<ProductItem>> {
        return productDao.getAllData()
    }

}