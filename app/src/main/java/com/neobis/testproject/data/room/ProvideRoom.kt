package com.neobis.testproject.data.room

import android.content.Context
import androidx.room.Room
import com.neobis.testproject.Constants.DATABASE_NAME

class ProvideRoom(context: Context) {

    private val applicationDatabase =
        Room.databaseBuilder(context, MyRoomDatabase::class.java, DATABASE_NAME).build()

    fun provide():MyRoomDatabase{
        return applicationDatabase
    }

}