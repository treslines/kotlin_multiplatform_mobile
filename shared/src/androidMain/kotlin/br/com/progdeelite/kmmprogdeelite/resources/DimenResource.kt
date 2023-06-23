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

actual class SurfaceDimensResource actual constructor(
    private val roundedCornerUnit: Int
) {
    val roundedCorner: Dp by lazy { roundedCornerUnit.dp }
}

actual class HeaderDimensResource actual constructor(
    private val defaultHeight: Int,
    private val defaultContentHeight: Int,
    private val defaultPaddingStart: Int,
    private val defaultPaddingTop: Int,
    private val defaultPaddingEnd: Int,
    private val defaultPaddingBottom: Int,
    private val defaultFakeBlurAlpha: Float
) {
    val height: Dp by lazy { defaultHeight.dp }
    val contentHeight: Dp by lazy { defaultContentHeight.dp }
    val paddingStart: Dp by lazy { defaultPaddingStart.dp }
    val paddingTop: Dp by lazy { defaultPaddingTop.dp }
    val paddingEnd: Dp by lazy { defaultPaddingEnd.dp }
    val paddingBottom: Dp by lazy { defaultPaddingBottom.dp }
    val fakeBlurAlpha: Float by lazy { defaultFakeBlurAlpha }
}

actual class ScreenDimensResource actual constructor(
    private val defaultPadding: Int,
    private val defaultStatusBarThreshold: Float,
    private val defaultBlendLimit: Float,
    private val defaultCurveInset: Int
) {
    val padding: Dp by lazy { defaultPadding.dp }
    val statusBarThreshold: Float by lazy { defaultStatusBarThreshold }
    val blendLimit: Float by lazy { defaultBlendLimit }
    val curveInset: Dp by lazy { defaultCurveInset.dp }
}

actual class CardDimensResource actual constructor(
    private val defaultCornerRadius: Int,
    private val defaultPadding: Int
) {
    val cornerRadius: Dp by lazy { defaultCornerRadius.dp }
    val padding: Dp by lazy { defaultPadding.dp }
}

actual class IconDimensResource actual constructor(
    private val defaultTiny: Int,
    private val defaultNormal: Int
) {
    val tiny: Dp by lazy { defaultTiny.dp }
    val normal: Dp by lazy { defaultNormal.dp }
}

actual class DefaultPaddingsResource actual constructor(
    private val defaultStart: Int,
    private val defaultEnd: Int,
    private val defaultTop: Int,
    private val defaultBottom: Int
) {
    val start: Dp by lazy { defaultStart.dp }
    val end: Dp by lazy { defaultEnd.dp }
    val top: Dp by lazy { defaultTop.dp }
    val bottom: Dp by lazy { defaultBottom.dp }
}

actual class TextFieldDimensResource actual constructor(
    private val minWidthUnit: Int,
    private val minHeightUnit: Int,
    private val roundCornerUnit: Int
) {
    val minWidth: Dp by lazy { minWidthUnit.dp }
    val minHeight: Dp by lazy { minHeightUnit.dp }
    val roundCorner: Dp by lazy { roundCornerUnit.dp }
}