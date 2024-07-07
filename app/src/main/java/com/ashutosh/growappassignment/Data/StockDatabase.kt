package com.ashutosh.growappassignment.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ashutosh.growappassignment.Data.TicketSearch.Dao.TicketSearchDao
import com.ashutosh.growappassignment.Data.TicketSearch.TicketSearchD

import com.ashutosh.growappassignment.Data.TopGainer.Dao.TopGainerDao
import com.ashutosh.growappassignment.Data.TopGainer.TopGainerD

import com.ashutosh.growappassignment.Data.TopLoser.Dao.TopLoserDao
import com.ashutosh.growappassignment.Data.TopLoser.TopLoserD


@Database( entities = [TopGainerD::class, TopLoserD::class, TicketSearchD::class], version = 1, exportSchema = false)
abstract class StockDatabase : RoomDatabase() {
    abstract fun topGainerDao(): TopGainerDao
    abstract fun topLoserDao(): TopLoserDao
    abstract fun ticketSearchDao(): TicketSearchDao
}
