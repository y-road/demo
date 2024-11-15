package com.song.app.demointro2.screen.main.intro

import com.song.app.demointro2.data.entity.intro.IntroEntity

sealed class IntroState {

    object Uninitialized: IntroState()

    object Loading: IntroState()

    data class Success(
        val introEntity: IntroEntity
    ): IntroState()

    object Failed: IntroState()

}
