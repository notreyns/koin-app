package com.neobis.testproject.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.neobis.testproject.data.model.Product
import com.neobis.testproject.data.model.ProductItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(model: ProductItem)

    @Query("SELECT * FROM productname")
    fun getAllData(): Flow<List<ProductItem>>

}