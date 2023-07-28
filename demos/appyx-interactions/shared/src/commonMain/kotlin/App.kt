import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
internal fun App() {
    MaterialTheme {
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
                    .offset(offset.x.dp, offset.y.dp)
                    .alpha(0.7f)
                    .background(Color.Green)
                    .pointerInput(Unit) {
                        detectDragGestures { _, dragAmount ->
                            offset += dragAmount
                        }
                    }
            )
        }

    }
}

expect fun getPlatformName(): String

@Composable
private fun AppyxTheme(
    content: @Composable () -> Unit
) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        content = content
    )
}

private val appyx_yellow1 = Color(0xFFFFC629)
private val appyx_yellow2 = Color(0xFFFFE54A)
private val appyx_dark = Color(0xFF1F2126)
private val appyx_bright = Color(0xFFFFFFFF)

private val DarkColorPalette = darkColors(
    primary = appyx_yellow1,
    primaryVariant = appyx_yellow2,
    secondary = appyx_yellow2,
    background = appyx_dark,
    surface = appyx_dark,
    onPrimary = appyx_bright,
    onSecondary = appyx_bright,
    onBackground = appyx_bright,
    onSurface = appyx_bright,
)

private val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)
