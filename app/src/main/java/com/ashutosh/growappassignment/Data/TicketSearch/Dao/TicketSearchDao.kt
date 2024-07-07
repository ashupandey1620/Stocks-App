package com.ashutosh.growappassignment.Data.TicketSearch.Dao

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ashutosh.growappassignment.Data.TicketSearch.TicketSearchD


import kotlinx.coroutines.flow.Flow

@Dao
interface TicketSearchDao {
    @Query("SELECT * FROM ticketSearch")
    fun getAllTicketSearch(): Flow<List<TicketSearchD>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTicketSearch(ticketSearch: TicketSearchD)

    @Query("DELETE FROM ticketSearch")
    suspend fun clearTicketSearch()

}