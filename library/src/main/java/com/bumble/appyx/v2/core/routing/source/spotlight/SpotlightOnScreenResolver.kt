package com.bumble.appyx.v2.core.routing.source.spotlight

import com.bumble.appyx.v2.core.routing.OnScreenStateResolver

object SpotlightOnScreenResolver : OnScreenStateResolver<Spotlight.TransitionState> {
    override fun isOnScreen(state: Spotlight.TransitionState): Boolean =
        when (state) {
            Spotlight.TransitionState.INACTIVE_BEFORE,
            Spotlight.TransitionState.INACTIVE_AFTER -> false
            Spotlight.TransitionState.ACTIVE -> true
        }
}