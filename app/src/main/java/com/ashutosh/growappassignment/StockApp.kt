package com.ashutosh.growappassignment

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Room
import com.ashutosh.growappassignment.Data.StockDatabase
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class StockApp: Application() {
    companion object {
        lateinit var database: StockDatabase
    }

    override fun onCreate() {
        super.onCreate()
        // Initialize Room Database
        database = Room.databaseBuilder(
            applicationContext,
            StockDatabase::class.java, "stock_database"
        ).build()
    }


}