package com.ashutosh.growappassignment.Data

import com.ashutosh.growappassignment.NetworkModule.Model.CompanyOverView.CompanyOverViewResponse
import com.ashutosh.growappassignment.NetworkModule.Model.TicketSearch.TicketSearchResponse
import com.ashutosh.growappassignment.NetworkModule.Model.TopGainAndLoss.TopGainAndLossResponse
import com.ashutosh.growappassignment.NetworkModule.NetworkResult
import com.ashutosh.growappassignment.NetworkModule.stockApi
import com.ashutosh.growappassignment.Util.result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


typealias topGainAndLoseResult = NetworkResult<TopGainAndLossResponse>
typealias ticketSearchResult = NetworkResult<TicketSearchResponse>
typealias companyOverViewResult = NetworkResult<CompanyOverViewResponse>

class Repository @Inject constructor(private val api : stockApi) {

    suspend fun topGainAndLose(function:String,apikey:String): Flow<NetworkResult<TopGainAndLossResponse>> = result{
        api.topGainAndLose(function,apikey)
    }

    suspend fun ticketSearch(function:String, keywords:String, apikey:String): Flow<NetworkResult<TicketSearchResponse>> = result{
        api.ticketSearch(function,keywords,apikey)
    }

    suspend fun companyOverView(function: String,symbol:String,apikey: String): Flow<NetworkResult<CompanyOverViewResponse>> = result{
        api.companyOverView(function,symbol,apikey)
    }

}