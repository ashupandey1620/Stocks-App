package com.ashutosh.growappassignment.NetworkModule

import com.ashutosh.growappassignment.NetworkModule.Model.CompanyOverView.CompanyOverViewResponse
import com.ashutosh.growappassignment.NetworkModule.Model.TicketSearch.TicketSearchResponse
import com.ashutosh.growappassignment.NetworkModule.Model.TopGainAndLoss.TopGainAndLossResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface stockApi {

    @Headers("Content-Type: application/json")
    @GET("/query")
    suspend fun ticketSearch(
        @Query("function") function: String ,
        @Query("keywords") keywords: String ,
        @Query("apikey") apikey: String ,
    ): Response<TicketSearchResponse>


    @Headers("Content-Type: application/json")
    @GET("/query")
    suspend fun companyOverView(
        @Query("function") function: String ,
        @Query("symbol") symbol: String ,
        @Query("apikey") apikey: String ,
    ): Response<CompanyOverViewResponse>


    @Headers("Content-Type: application/json")
    @GET("/query")
    suspend fun topGainAndLose(
        @Query("function") function: String ,
        @Query("apikey") apikey: String ,
    ): Response<TopGainAndLossResponse>


}