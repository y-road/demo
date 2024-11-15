package com.song.app.demointro2.data.response.intro

import com.song.app.demointro2.data.entity.intro.TickerEntity

data class TickerResponse(
    val v: String,
    val qv: String
) {
    
    fun toEntity() = TickerEntity(
        v = v,
        qv = qv
    )
    
}
