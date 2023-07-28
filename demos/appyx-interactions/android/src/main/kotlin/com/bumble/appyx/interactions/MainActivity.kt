package com.bumble.appyx.interactions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.bumble.appyx.components.experimental.cards.android.DatingCards
import com.bumble.appyx.components.experimental.puzzle15.android.Puzzle15
import com.bumble.appyx.components.internal.testdrive.android.TestDriveExperiment
import com.bumble.appyx.components.spotlight.ui.fader.SpotlightFader
import com.bumble.appyx.components.spotlight.ui.slider.SpotlightSlider
import com.bumble.appyx.components.spotlight.ui.sliderrotation.SpotlightSliderRotation
import com.bumble.appyx.components.spotlight.ui.sliderscale.SpotlightSliderScale
import com.bumble.appyx.components.spotlight.ui.stack3d.SpotlightStack3D
import com.bumble.appyx.interactions.sample.SpotlightExperiment
import com.bumble.appyx.interactions.sample.SpotlightExperimentInVertical
import com.bumble.appyx.interactions.theme.AppyxTheme
import com.bumble.appyx.interactions.theme.appyx_dark
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Suppress("MagicNumber")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppyxTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = appyx_dark
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        var offset by remember { mutableStateOf(Offset.Zero) }
                        Box(
                            modifier = Modifier
                                .size(150.dp)
                                .alpha(0.7f)
                                .background(Color.Red)
                        )
                        Box(
                            modifier = Modifier
                                .size(150.dp)
                                .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
                                .alpha(0.7f)
                                .background(Color.Green)
                                .pointerInput(Unit) {
                                    detectDragGestures { _, dragAmount ->
                                        offset += dragAmount
                                    }
                                }
                        )
                    }

//                    var content by remember { mutableStateOf(1) }
//                    Column {
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(4.dp),
//                            horizontalArrangement = Arrangement.Center
//                        ) {
//                            Button({ content = 1 }) { Text("1") }
//                            Button({ content = 2 }) { Text("2") }
//                            Button({ content = 3 }) { Text("3") }
//                            Button({ content = 4 }) { Text("4") }
//                            Button({ content = 5 }) { Text("5") }
//                            Button({ content = 6 }) { Text("6") }
//                            Button({ content = 7 }) { Text("7") }
//                        }
//                        when (content) {
//                            1 -> DatingCards()
//                            2 -> SpotlightExperimentInVertical { SpotlightStack3D(it) }
//                            3 -> SpotlightExperiment { SpotlightSliderScale(it) }
//                            4 -> SpotlightExperiment { SpotlightSliderRotation(it) }
//                            5 -> SpotlightExperiment { SpotlightFader(it) }
//                            6 -> TestDriveExperiment()
//                            7 -> Puzzle15()
//                            else -> SpotlightExperiment { SpotlightSlider(it) }
//                        }
//                    }
                }
            }
        }
    }
}

