package com.ashutosh.growappassignment.Data.TopGainer

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topGain")
data class TopGainerD(
    @PrimaryKey
    val ticker: String ,
    val price: String ,
    val change_percentage: String ,
    val change_amount: String ,
    val volume: String,
    val icon:Int
)
