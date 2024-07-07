package com.ashutosh.growappassignment.Data.CompanyOverView.Dao

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ashutosh.growappassignment.Data.CompanyOverView.CompanyOverViewD
import com.ashutosh.growappassignment.Data.TicketSearch.TicketSearchD


import kotlinx.coroutines.flow.Flow

@Dao
interface CompanyOverViewDao {
    @Query("SELECT * FROM companyOverview")
    fun getCompanyOverView(): Flow<List<CompanyOverViewD>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanyOverView(companyOverView: CompanyOverViewD)

    @Query("DELETE FROM companyOverview")
    suspend fun clearCompanyOverView()

}