package net.runner.asme_iitr.composables

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import net.runner.asme_iitr.ui.theme.BgGradient1
import net.runner.asme_iitr.ui.theme.BgGradient2

fun getBackGroundGradientBrush(screenWidth: Dp, screenHeight: Dp): Brush {
    return Brush.linearGradient(
        colors = listOf(BgGradient1, BgGradient2),
        start = Offset(0f, 0f),
        end = Offset(screenWidth.value, screenHeight.value*3.5f)
    )
}