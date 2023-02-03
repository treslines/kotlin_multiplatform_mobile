package br.com.progdeelite.kmmprogdeelite.resources

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual class ButtonDimensResource actual constructor(
    private val roundedCornerUnit: Int,
    private val minWidthUnit: Int,
    private val heightUnit: Int,
    private val smallHeightUnit: Int
) {
    val roundedCorner: Dp by lazy { roundedCornerUnit.dp }
    val minWidth: Dp by lazy { minWidthUnit.dp }
    val height: Dp by lazy { heightUnit.dp }
    val smallHeight: Dp by lazy { smallHeightUnit.dp }
}

actual class TextFieldDimensResource actual constructor(
    private val minWidthUnit: Int,
    private val minHeightUnit: Int
) {
    val minWidth: Dp by lazy { minWidthUnit.dp }
    val minHeight: Dp by lazy { minHeightUnit.dp }
}