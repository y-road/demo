package com.song.app.demointro2.data.entity.intro

import android.os.Parcelable
import com.song.app.demointro2.data.entity.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
data class IntroEntity(
    val indexPrice: String,
    val estimatedFundingRate: String, // getFundingRates: settleRate
    val remainTime: String, // getFundingRates: lastSettleTime
    val fundingRate: String, // getFundingRates: fundingRate
    val initialMargin: String,
    val maintenanceMargin: String,
    val transactionAmount: String, // getTicker
    val transactionVolume: String, // getTicker
    val minimumChangeInPrice: String,
    val minimumOrder: String,
): Entity, Parcelable
