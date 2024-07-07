package com.ashutosh.growappassignment.Data.CompanyOverView

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date


@Entity(tableName = "companyOverview")
data class CompanyOverViewD(
    @PrimaryKey
    val symbol: String ,
    val MarketCapitalization: String ,
    val Name: String ,
    @ColumnInfo(name = "52WeekHigh") val weekHigh52: String ,
    @ColumnInfo(name = "52WeekLow") val weekLow52: String,
    val AnalystTargetPrice: String ,
    val AssetType: String ,
    val Beta: String ,
    val DividendYield: String ,
    val ProfitMargin: String ,
    val PERatio: String ,
    val Sector: String ,
    val Industry: String ,
    val expirationDate: String
)
