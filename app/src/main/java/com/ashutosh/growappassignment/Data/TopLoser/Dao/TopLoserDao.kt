package com.ashutosh.growappassignment.Data.TopLoser.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ashutosh.growappassignment.Data.TopLoser.TopLoserD

import kotlinx.coroutines.flow.Flow


@Dao
interface TopLoserDao {
    @Query("SELECT * FROM topLose")
    fun getAllTopLoser(): Flow<List<TopLoserD>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopLoser(topLoser: List<TopLoserD>)

    @Query("DELETE FROM topLose")
    suspend fun clearTopLoser()

    @Query("DELETE FROM topLose WHERE ticker = :ticker")
    suspend fun deleteStockById(ticker: String)

    @Query("SELECT COUNT(*) FROM topLose WHERE ticker = :ticker")
    suspend fun isStockInCart(ticker: String): String

}