package com.song.app.demointro2.data.entity.intro

import android.os.Parcelable
import com.song.app.demointro2.data.entity.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
data class FundingRateListEntity(
    val fundingRateList: List<FundingRateEntity>
): Entity, Parcelable
