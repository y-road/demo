package com.song.app.demointro2.data.network

import com.song.app.demointro2.data.response.intro.FundingRateResponse
import com.song.app.demointro2.data.response.intro.TickerListResponse
import com.song.app.demointro2.data.url.Url
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface TokenAPIService {

    @GET(Url.GET_TICKER)
    suspend fun getTicker(
        @Query("symbol") symbol: String? = null,
        @Query("realtimeInterval") interval: String? = null
    ): Response<TickerListResponse>

    @GET(Url.GET_FUTURES_FUNDING_RATES)
    suspend fun getFundingRateList(): Response<List<FundingRateResponse>>

}
