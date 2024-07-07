package com.ashutosh.growappassignment.NetworkModule.Model.TicketSearch

import com.ashutosh.growappassignment.NetworkModule.Model.TicketSearch.BestMatch

data class TicketSearchResponse(
    val bestMatches: List<BestMatch>
)