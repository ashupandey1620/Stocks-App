package com.ashutosh.growappassignment.Data.TopLoser

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topLose")
data class TopLoserD(
    @PrimaryKey
    val ticker: String ,
    val price: String ,
    val change_percentage: String ,
    val change_amount: String ,
    val volume: String,
    val icon:Int
)

