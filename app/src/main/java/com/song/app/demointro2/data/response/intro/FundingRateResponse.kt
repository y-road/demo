package com.song.app.demointro2.data.response.intro

import com.song.app.demointro2.data.entity.intro.FundingRateEntity

data class FundingRateResponse(
    val tokenId: String,
    val curServerTime: String,
    val lastSettleTime: String,
    val settleRate: String,
    val nextSettleTime: String,
    val fundingRate: String
) {

    fun toEntity() = FundingRateEntity(
        tokenId = tokenId,
        curServerTime = curServerTime,
        lastSettleTime = lastSettleTime,
        settleRate = settleRate,
        nextSettleTime = nextSettleTime,
        fundingRate = fundingRate,
    )

}
