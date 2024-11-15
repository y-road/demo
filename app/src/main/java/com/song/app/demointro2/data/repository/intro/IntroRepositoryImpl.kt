package com.song.app.demointro2.data.repository.intro

import com.song.app.demointro2.data.entity.intro.FundingRateListEntity
import com.song.app.demointro2.data.entity.intro.TickerListEntity
import com.song.app.demointro2.data.network.TokenAPIService
import com.song.app.demointro2.data.response.intro.FundingRateResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class IntroRepositoryImpl @Inject constructor(
    @Named("IoDispatcher") private val ioDispatcher: CoroutineDispatcher,
    private val tokenAPIService: TokenAPIService
): IntroRepository {

    override suspend fun getTicker(symbol: String, realtimeInterval: String): TickerListEntity = withContext(ioDispatcher) {

        val response = tokenAPIService.getTicker(symbol = symbol, interval = realtimeInterval)

        if (response.isSuccessful) {
            response.body()?.toEntity() ?: TickerListEntity(emptyList())
        } else {
            TickerListEntity(emptyList())
        }

    }

    override suspend fun getFundingRates(): FundingRateListEntity = withContext(ioDispatcher) {

        val response: Response<List<FundingRateResponse>> = tokenAPIService.getFundingRateList()

        if (response.isSuccessful) {
            FundingRateListEntity(response.body()?.map { it.toEntity() } ?: emptyList())
        } else {
            FundingRateListEntity(emptyList())
        }

    }

}
