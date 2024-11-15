package com.song.app.demointro2.data.response.intro

import com.song.app.demointro2.data.entity.intro.TickerListEntity

data class TickerListResponse(
    val data: List<TickerResponse>
) {

    fun toEntity() = TickerListEntity(
        data = data.map { it.toEntity() }
    )

}
