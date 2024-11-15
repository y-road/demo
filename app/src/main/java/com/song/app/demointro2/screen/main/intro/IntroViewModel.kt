package com.song.app.demointro2.screen.main.intro

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.song.app.demointro2.data.entity.intro.FundingRateEntity
import com.song.app.demointro2.data.entity.intro.IntroEntity
import com.song.app.demointro2.data.repository.intro.IntroRepository
import com.song.app.demointro2.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(
    private val introRepository: IntroRepository
) : BaseViewModel() {

    val introStateLiveData = MutableLiveData<IntroState>(IntroState.Uninitialized)

    override fun fetchData(): Job = viewModelScope.launch {

        introStateLiveData.value = IntroState.Loading

        val tickerEntity = introRepository.getTicker("301.BTC-SWAP-USDT", "1d").data[0]
        val fundingRateEntity: FundingRateEntity = introRepository.getFundingRates().fundingRateList.filter { it.tokenId == "BTC-SWAP-USDT" }[0]

        introStateLiveData.value = IntroState.Success(
            introEntity = IntroEntity(
                indexPrice = "-",
                estimatedFundingRate = fundingRateEntity.settleRate,
                remainTime = fundingRateEntity.lastSettleTime,
                fundingRate = fundingRateEntity.fundingRate,
                initialMargin = "-",
                maintenanceMargin = "-",
                transactionAmount = tickerEntity.qv,
                transactionVolume = tickerEntity.v,
                minimumChangeInPrice = "-",
                minimumOrder = "-"
            )
        )
//        introStateLiveData.value =
    }

}
