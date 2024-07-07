package com.ashutosh.growappassignment.Data

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.ashutosh.growappassignment.Data.CompanyOverView.CompanyOverViewD
import com.ashutosh.growappassignment.Data.CompanyOverView.Dao.CompanyOverViewDao
import com.ashutosh.growappassignment.Data.TicketSearch.Dao.TicketSearchDao
import com.ashutosh.growappassignment.Data.TicketSearch.TicketSearchD

import com.ashutosh.growappassignment.Data.TopGainer.Dao.TopGainerDao
import com.ashutosh.growappassignment.Data.TopGainer.TopGainerD

import com.ashutosh.growappassignment.Data.TopLoser.Dao.TopLoserDao
import com.ashutosh.growappassignment.Data.TopLoser.TopLoserD


@Database( entities = [TopGainerD::class, TopLoserD::class, TicketSearchD::class, CompanyOverViewD::class], version = 1, exportSchema = false)
abstract class StockDatabase : RoomDatabase() {
    abstract fun topGainerDao(): TopGainerDao
    abstract fun topLoserDao(): TopLoserDao
    abstract fun ticketSearchDao(): TicketSearchDao
    abstract fun companyOverViewDao(): CompanyOverViewDao

//    companion object {
//        @Volatile private var instance: StockDatabase? = null
//
//        fun getInstance(context: Context): StockDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//        }
//
//        private fun buildDatabase(context: Context): StockDatabase {
//            return Room.databaseBuilder(context.applicationContext,
//                Stock::class.java, "your_database_name")
//                .build()
//        }
//    }
}
