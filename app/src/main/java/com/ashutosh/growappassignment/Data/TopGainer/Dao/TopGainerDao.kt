package com.ashutosh.growappassignment.Data.TopGainer.Dao

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ashutosh.growappassignment.Data.TopGainer.TopGainerD

import kotlinx.coroutines.flow.Flow

@Dao
interface TopGainerDao {
    @Query("SELECT * FROM topGain")
    fun getAllTopGainer(): Flow<List<TopGainerD>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopGainer(cartitem: List<TopGainerD>)

    @Query("DELETE FROM topGain")
    suspend fun clearTopGainer()

    @Query("DELETE FROM topGain WHERE ticker = :ticker")
    suspend fun deleteStockById(ticker: String)

    @Query("SELECT COUNT(*) FROM topGain WHERE ticker = :ticker")
    suspend fun isStockInCart(ticker: String): String

}