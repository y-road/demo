package com.song.app.demointro2.data.repository.intro

import com.song.app.demointro2.data.entity.intro.FundingRateListEntity
import com.song.app.demointro2.data.entity.intro.TickerListEntity

interface IntroRepository {

    suspend fun getTicker(
        symbol: String,
        realtimeInterval: String
    ): TickerListEntity

    suspend fun getFundingRates(): FundingRateListEntity

}
