package com.bumble.appyx.navigation.node.backstack

import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.BackStackModel
import com.bumble.appyx.components.backstack.operation.push
import com.bumble.appyx.components.backstack.ui.fader.BackstackFader
import com.bumble.appyx.components.backstack.ui.slider.BackStackSlider
import com.bumble.appyx.navigation.composable.Children
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import com.bumble.appyx.navigation.node.ParentNode
import com.bumble.appyx.navigation.node.backstack.BackStackExamplesNode.InteractionTarget
import com.bumble.appyx.navigation.node.node
import com.bumble.appyx.navigation.ui.TextButton
import com.bumble.appyx.navigation.ui.appyx_dark
import kotlinx.parcelize.Parcelize


class BackStackExamplesNode(
    buildContext: BuildContext,
    private val backStack: BackStack<InteractionTarget> = BackStack(
        model = BackStackModel(
            initialTargets = listOf(InteractionTarget.BackStackPicker),
            savedStateMap = buildContext.savedStateMap
        ),
        motionController = { BackStackSlider(it) }
    )
) : ParentNode<InteractionTarget>(
    buildContext = buildContext,
    interactionModel = backStack
) {

    sealed class InteractionTarget : Parcelable {
        @Parcelize
        object BackStackPicker : InteractionTarget()

        @Parcelize
        object BackStackSlider : InteractionTarget()

        @Parcelize
        object BackStackFader : InteractionTarget()
    }

    override fun resolve(interactionTarget: InteractionTarget, buildContext: BuildContext): Node =
        when (interactionTarget) {
            is InteractionTarget.BackStackPicker -> node(buildContext) {
                BackStackPicker(it)
            }
            is InteractionTarget.BackStackFader -> BackStackNode(buildContext, {
                BackstackFader(
                    it
                )
            })
            is InteractionTarget.BackStackSlider -> BackStackNode(buildContext, {
                BackStackSlider(
                    it
                )
            })
        }

    @Composable
    private fun BackStackPicker(modifier: Modifier = Modifier) {
        val scrollState = rememberScrollState()
        Box(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TextButton(text = "BackStack slider") {
                    backStack.push(InteractionTarget.BackStackSlider)
                }
                TextButton(text = "BackStack fader") {
                    backStack.push(InteractionTarget.BackStackFader)
                }
            }
        }
    }

    @Composable
    override fun View(modifier: Modifier) {
        Children(
            interactionModel = backStack,
            modifier = Modifier
                .fillMaxSize()
                .background(appyx_dark)
                .padding(16.dp),
        )
    }
}
