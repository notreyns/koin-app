package com.neobis.testproject.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.neobis.testproject.data.model.ProductItem

@Database(entities = [ProductItem::class], version = 1, exportSchema = false)
abstract class MyRoomDatabase():RoomDatabase() {

    abstract fun productDao():ProductDao

}