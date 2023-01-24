package com.bumble.appyx.interactions.core.ui

import com.bumble.appyx.interactions.core.NavElement

data class MatchedProps<NavTarget, Props>(
    val element: NavElement<NavTarget>,
    val props: Props
)
