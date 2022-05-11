package com.bumble.appyx.v2.app.node.teaser.promoter.routingsource

import com.bumble.appyx.v2.app.node.teaser.promoter.routingsource.Promoter.TransitionState
import com.bumble.appyx.v2.core.routing.onscreen.OnScreenStateResolver

internal object PromoterOnScreenResolver : OnScreenStateResolver<TransitionState> {
    override fun isOnScreen(state: TransitionState): Boolean =
        when (state) {
            TransitionState.DESTROYED -> false
            else -> true
        }
}