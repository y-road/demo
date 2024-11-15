package com.song.app.demointro2.data.entity.intro

import com.song.app.demointro2.data.entity.Entity

data class TickerListEntity(
    val data: List<TickerEntity>
): Entity
