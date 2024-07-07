package com.ashutosh.growappassignment.Data.TicketSearch

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ticketSearch")
data class TicketSearchD(
    @PrimaryKey
    val symbol: String ,
    val name: String ,
)

