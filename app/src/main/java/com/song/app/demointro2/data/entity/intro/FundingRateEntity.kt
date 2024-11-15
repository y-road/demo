package com.song.app.demointro2.data.entity.intro

import android.os.Parcelable
import com.song.app.demointro2.data.entity.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
data class FundingRateEntity(
    val tokenId: String,
    val curServerTime: String,
    val lastSettleTime: String,
    val settleRate: String,
    val nextSettleTime: String,
    val fundingRate: String,
): Entity, Parcelable
